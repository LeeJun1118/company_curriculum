package com.spring.board.controller;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Board> boardList = boardRepository.findAll();
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/board/{id}")
    public String showBoard(@PathVariable("id") Long id, Model model){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board",board);

        return "boards/showBoard";
    }

    @GetMapping("/board/new")
    public String boardForm(Model model){
        model.addAttribute("newBoard",new BoardForm());
        return "boards/newBoard";
    }
}
