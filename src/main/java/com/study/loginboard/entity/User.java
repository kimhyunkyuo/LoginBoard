package com.study.loginboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {
    @Id //pk지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 시퀀스
    @Column(name = "user_id")
    private  Long id;

    @Column
    private String loginId;

    @Column
    private String userPassword;

    @Column
    private String userName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    // OAuth 로그인에 사용
    private String provider;
    private String providerId;
}
