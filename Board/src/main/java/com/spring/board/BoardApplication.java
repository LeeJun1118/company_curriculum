package com.spring.board;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }
    /*@Bean
    public CommandLineRunner runner(BoardRepository boardRepository){
        return (args) -> {
            boardRepository.save(Board.builder().title("myTitle1").content("1@1.com").build());
            boardRepository.save(Board.builder().title("myTitle2").content("2@2.com").build());

        };
    }*/
}
