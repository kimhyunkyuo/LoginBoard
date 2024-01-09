package com.study.loginboard.service;

import com.study.loginboard.dto.CommentRequestDTO;
import com.study.loginboard.dto.CommentResponseDTO;
import com.study.loginboard.entity.Board;
import com.study.loginboard.entity.Comment;
import com.study.loginboard.entity.User;
import com.study.loginboard.repository.BoardRepository;
import com.study.loginboard.repository.CommentRepository;
import com.study.loginboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;

    @Override
    public Long writeComment(CommentRequestDTO commentRequestDTO, Long boardId,  String loginId) {
        User user = userRepository.findByLoginId(loginId).orElseThrow(() -> new UsernameNotFoundException("이메일이 존재하지 않습니다."));
        Board board = boardRepository.findById(boardId).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
        Comment result = Comment.builder()
                .content(commentRequestDTO.getContent())
                .board(board)
                .user(user)
                .build();
        commentRepository.save(result);

        return result.getId();
    }

    @Override
    public List<CommentResponseDTO> commentList(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물을 찾을 수 없습니다."));
        List<Comment> comments = commentRepository.findByBoard(board);

        return comments.stream()
                .map(comment -> CommentResponseDTO.builder()
                        .comment(comment)
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void updateComment(CommentRequestDTO commentRequestDTO, Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        comment.update(commentRequestDTO.getContent());
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}

