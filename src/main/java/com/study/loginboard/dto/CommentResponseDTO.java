package com.study.loginboard.dto;

import com.study.loginboard.entity.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDTO {

    private LocalDateTime  createdTime;
    private LocalDateTime  updatedTime;
    private Long id;
    private String content;
    private String userName;
    private String loginId;

    @Builder
    public CommentResponseDTO(Comment comment){
         this.createdTime =  comment.getCreatedTime();
         this.updatedTime = comment.getUpdatedTime();
         this.id = comment.getId();
         this.content = comment.getContent();
         this.userName = comment.getUser().getUserName();
         this.loginId = comment.getUser().getLoginId();

}
}
