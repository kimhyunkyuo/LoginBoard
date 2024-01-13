package com.study.loginboard.service;

import com.study.loginboard.dto.JoinDTO;
import com.study.loginboard.dto.LoginDTO;
import com.study.loginboard.entity.User;
import com.study.loginboard.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public boolean checkLoginIdDuplicate(String loginId) {

        return userRepository.existsByLoginId(loginId);
    }

    public void join(JoinDTO req) {
        userRepository.save(req.toEntity(encoder.encode(req.getUserPassword())));

    }
    public User getLoginUserByLoginId(String loginId) {
        if (loginId == null) return null;

        Optional<User> optionalUser = userRepository.findByLoginId(loginId);
        if (optionalUser.isEmpty()) return null;

        return optionalUser.get();
    }
}