package com.spring.board.repository;

import com.spring.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Page<Board> findAllByTitleContaining(String title,Pageable pageable);
    List<Board> findByTitleContaining(String title);
}
