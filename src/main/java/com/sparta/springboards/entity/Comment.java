package com.sparta.springboards.entity;

import com.sparta.springboards.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

//    @Column(nullable = false)
//    private Long boardid;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    public Comment(CommentRequestDto requestDto, User user, Board board){
        this.username = user.getUsername();
        this.contents = requestDto.getContents();
        this.board = board;
        this.user = user;


//        this.boardid = board.getId();
    }

}
