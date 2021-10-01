package com.spring.board.repository;

import com.spring.board.domain.MyFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyFileRepository extends JpaRepository<MyFile,Long> {
}
