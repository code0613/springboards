package com.sparta.springboards.service;

import com.sparta.springboards.dto.CommentRequestDto;
import com.sparta.springboards.dto.CommentResponseDto;
import com.sparta.springboards.entity.Board;
import com.sparta.springboards.entity.Comment;
import com.sparta.springboards.entity.User;
import com.sparta.springboards.jwt.JwtUtil;
import com.sparta.springboards.repository.BoardRepository;
import com.sparta.springboards.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final JwtUtil jwtUtil;

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto, User user, Long id) {
        Board board;
        board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
        Comment comment = commentRepository.save(new Comment(requestDto,user,board));
        return new CommentResponseDto(comment);
    }
}
