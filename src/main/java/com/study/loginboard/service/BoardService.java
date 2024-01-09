package com.study.loginboard.service;

import com.study.loginboard.dto.BoardImageUploadDTO;
import com.study.loginboard.dto.BoardResponseDTO;
import com.study.loginboard.dto.BoardWriteRequestDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    Long saveBoard(BoardWriteRequestDTO boardWriteRequestDTO,
                   BoardImageUploadDTO boardImageUploadDTO,
                   String userName);
    Page<BoardResponseDTO> boardList(Pageable pageable);
    BoardResponseDTO boardDetail(Long id);

    Long boardUpdate(Long id, BoardWriteRequestDTO boardWriteRequestDTO);

    void boardRemove(Long id);
}

