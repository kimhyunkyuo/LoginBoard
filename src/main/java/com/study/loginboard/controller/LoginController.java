package com.study.loginboard.controller;

import com.study.loginboard.dto.JoinDTO;
import com.study.loginboard.dto.LoginDTO;
import com.study.loginboard.entity.User;
import com.study.loginboard.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final  UserService userService;

    @GetMapping(value = { "/"})
    public String home(Model model, Authentication auth) {

        if(auth != null) {
            User loginUser = userService.getLoginUserByLoginId(auth.getName());
            if (loginUser != null) {
                model.addAttribute("userName", loginUser.getUserName());
            }
        }
        return "index";
    }


    @GetMapping("/join")
    public String joinPage(Model model) {
        model.addAttribute("joinDTO", new JoinDTO());
        return "join";
    }

    @PostMapping("/join")
    public String join(@Valid @ModelAttribute JoinDTO joinDTO, BindingResult bindingResult) {
        // loginId 중복 체크
        if(userService.checkLoginIdDuplicate(joinDTO.getLoginId())) {
            bindingResult.addError(new FieldError("joinDTO", "loginId", "로그인 아이디가 중복됩니다."));
        }
        // password와 passwordCheck가 같은지 체크
        if(!joinDTO.getUserPassword().equals(joinDTO.getUserPassWordCheck())) {
            bindingResult.addError(new FieldError("joinDTO", "userPassWordCheck", "비밀번호가 일치하지 않습니다."));
        }
        if(bindingResult.hasErrors()) {
            return "join";
        }
        userService.join(joinDTO);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "exception", required = false) String exception,
                            Model model) {

        model.addAttribute("loginDTO", new LoginDTO());
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "login";
    }

    @GetMapping("/info")
    public String userInfo(Model model, Authentication auth) {

        User loginUser = userService.getLoginUserByLoginId(auth.getName());
        model.addAttribute("user", loginUser);

        return "info";
    }


}