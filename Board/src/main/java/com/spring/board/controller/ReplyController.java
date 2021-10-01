package com.spring.board.controller;

import com.spring.board.domain.Board;
import com.spring.board.domain.Reply;
import com.spring.board.repository.BoardRepository;
import com.spring.board.repository.ReplyRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class ReplyController {

    private final ReplyRepository replyRepository;
    private final BoardRepository boardRepository;

    @PostMapping("/reply/new/{id}")
    public String createBoard(@PathVariable("id") Long id,
                              @Valid ReplyForm replyForm,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "boards/showBoard";
        }
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        Reply reply = new Reply();
        reply.setBoard(board);
        reply.setContent(replyForm.getContent());
        replyRepository.save(reply);
        return "redirect:/board/" + board.getId();
    }
}
