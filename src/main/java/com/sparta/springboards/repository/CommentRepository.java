package com.sparta.springboards.repository;

import com.sparta.springboards.entity.Board;
import com.sparta.springboards.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

//    List<Comment> findByBoardId(Long id);
    List<Comment> findByBoard_Id(Long id);

    List<Comment> findByBoard(Board board);
}

