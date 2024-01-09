package com.study.loginboard.dto;

import com.study.loginboard.entity.User;
import com.study.loginboard.entity.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class JoinDTO {
    @NotBlank(message =  "아이디는 필수입니다.")
    private String loginId;
    private String userPassword;
    private String userPassWordCheck;
    private String userName;

    public User toEntity(String encodedPassword){
        return User.builder()
                .loginId(this.loginId)
                .userPassword(encodedPassword)
                .userName(this.userName)
                .role(UserRole.USER)
                .build();
    }
}