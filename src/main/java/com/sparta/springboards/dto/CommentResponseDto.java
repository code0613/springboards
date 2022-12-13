package com.sparta.springboards.dto;

import com.sparta.springboards.entity.Board;
import com.sparta.springboards.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private Long id;
    private String username;
    private String contents;

//    private Board board;

    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.username = comment.getUsername();
        this.contents = comment.getContents();
    }

}
