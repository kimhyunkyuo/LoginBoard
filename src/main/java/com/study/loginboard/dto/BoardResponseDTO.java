package com.study.loginboard.dto;

import com.study.loginboard.entity.Board;
import com.study.loginboard.entity.BoardImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class BoardResponseDTO {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdTime;
    private String userName;
    private String loginId;
    private List<String> imageUrls;



    @Builder
    public BoardResponseDTO(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.createdTime = board.getCreatedTime();
        this.userName = board.getUser().getUserName();
        this.loginId = board.getUser().getLoginId();
        this.imageUrls = board.getBoardImages().stream()
                .map(BoardImage::getUrl)
                .collect(Collectors.toList());


    }
}
