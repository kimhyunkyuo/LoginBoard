package com.study.loginboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LoginBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginBoardApplication.class, args);
	}

}
