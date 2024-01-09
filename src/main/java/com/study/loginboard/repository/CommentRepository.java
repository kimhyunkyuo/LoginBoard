package com.study.loginboard.repository;

import com.study.loginboard.entity.Board;
import com.study.loginboard.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByBoard(Board board);
}
