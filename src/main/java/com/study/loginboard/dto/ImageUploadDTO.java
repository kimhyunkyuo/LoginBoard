package com.study.loginboard.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data
    public class ImageUploadDTO {

        private MultipartFile file;
    }

