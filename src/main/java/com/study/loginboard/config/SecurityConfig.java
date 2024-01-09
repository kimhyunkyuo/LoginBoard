package com.study.loginboard.config;

import com.study.loginboard.auth.oauth.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationFailureHandler customAuthFailureHandler;
    private final PrincipalOauth2UserService principalOauth2UserService;
    //비밀번호 암호화
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return  new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf((auth) -> auth.disable()
                );

        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/","/login","/join","/board/list","/board/detail").permitAll()
                        .anyRequest().authenticated()
                );
        http
                .formLogin((customizer) -> customizer
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("loginId")
                        .passwordParameter("userPassword")
                        .failureHandler(customAuthFailureHandler)
                        .permitAll()
                );
        http
                .logout(customizer -> customizer
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
        );
        // OAuth 로그인
        http
                .oauth2Login((oauth2) -> oauth2
                        .loginPage("/oauth2/authorization/google")
                        .defaultSuccessUrl("/")
                        .userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userService(principalOauth2UserService))
                );
        return http.build();
    }

    
}
