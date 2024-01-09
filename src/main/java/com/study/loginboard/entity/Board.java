package com.study.loginboard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER)
    @OrderBy("id asc")
    private List<Comment> comments;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE,  fetch = FetchType.EAGER)
    @OrderBy("id asc")
    private List<BoardImage> boardImages;

    public void update(String title, String content) {
        this.title = title;
        this.content = content;


    }
}
