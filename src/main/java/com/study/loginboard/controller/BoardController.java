package com.study.loginboard.controller;
import com.study.loginboard.dto.BoardImageUploadDTO;
import com.study.loginboard.dto.BoardResponseDTO;
import com.study.loginboard.dto.BoardWriteRequestDTO;
import com.study.loginboard.dto.CommentResponseDTO;
import com.study.loginboard.service.BoardService;
import com.study.loginboard.service.CommentService;
import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/write")
    public String writeForm() {
        return "board/write";
    }


    @PostMapping("/write")
    public String write(BoardWriteRequestDTO boardWriteRequestDTO,
                        @ModelAttribute BoardImageUploadDTO boardImageUploadDTO,
                        Authentication authentication) {

        logger.info("boardImageDTO is {}", boardImageUploadDTO);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        boardService.saveBoard(boardWriteRequestDTO, boardImageUploadDTO, userDetails.getUsername());

        return "redirect:/";
    }

    @GetMapping("/list")
    public String boardList(Model model, @PageableDefault(page = 0, size = 10, sort = "id",
            direction = Sort.Direction.DESC)Pageable pageable) {
            model.addAttribute("boardList",boardService.boardList(pageable));

        return "board/list";
    }

    @GetMapping("/{id}")
    public String boardDetail(@PathVariable Long id, Model model) {
        BoardResponseDTO result = boardService.boardDetail(id);
        List<CommentResponseDTO> commentResponseDTO = commentService.commentList(id);
        model.addAttribute("comments", commentResponseDTO);
       model.addAttribute("dto", result);
        model.addAttribute("id", id);

        return "board/detail";
    }

    @GetMapping("/{id}/update")
    public String boardUpdateForm(@PathVariable Long id, Model model, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        BoardResponseDTO result = boardService.boardDetail(id);
        if (!result.getLoginId().equals(userDetails.getUsername())) {
            return "redirect:/";
        }

        model.addAttribute("dto", result);
        model.addAttribute("id", id);

        return "board/update";
    }

    /**
     * 게시글 수정 post
     * @param id 게시글 ID
     * @param boardWriteRequestDTO 수정 정보
     * @return 게시글 상세 조회 페이지
     */
    @PostMapping("/{id}/update")
    public String boardUpdate(@PathVariable Long id, BoardWriteRequestDTO boardWriteRequestDTO) {
        boardService.boardUpdate(id, boardWriteRequestDTO);

        return "redirect:/board/" + id;
    }

    @GetMapping("/{id}/remove")
    public String boardRemove(@PathVariable Long id, Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        BoardResponseDTO result = boardService.boardDetail(id);
        if (!Objects.equals(result.getLoginId(), userDetails.getUsername())) {
            return "redirect:/";
        }

        boardService.boardRemove(id);

        return "redirect:/";
    }



}