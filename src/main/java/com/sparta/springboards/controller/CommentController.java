package com.sparta.springboards.controller;

import com.sparta.springboards.dto.CommentRequestDto;
import com.sparta.springboards.dto.CommentResponseDto;
import com.sparta.springboards.entity.Board;
import com.sparta.springboards.security.UserDetailsImpl;
import com.sparta.springboards.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment/{id}")
    public CommentResponseDto createComment(@RequestBody CommentRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id){
        return commentService.createComment(requestDto,userDetails.getUser(),id);
    }

}

