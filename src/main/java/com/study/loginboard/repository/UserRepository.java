package com.study.loginboard.repository;

import com.study.loginboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    // 이메일로 회원 정보 조회
    boolean existsByLoginId(String loginId);
    Optional<User> findByLoginId(String loginId);
}