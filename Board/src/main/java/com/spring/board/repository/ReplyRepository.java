package com.spring.board.repository;

import com.spring.board.domain.Board;
import com.spring.board.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByBoard(Board board);
    Reply findByBoard(Board board);
}
