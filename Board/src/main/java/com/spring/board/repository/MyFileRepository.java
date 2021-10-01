package com.spring.board.repository;

import com.spring.board.domain.Board;
import com.spring.board.domain.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyFileRepository extends JpaRepository<MyFile,Long> {
    List<MyFile> findAllByBoard(Board board);
}
