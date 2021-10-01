package com.spring.board.controller;

import com.spring.board.domain.Board;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class ReplyForm {
    @NotEmpty(message = "내용을 입력해주세요")
    private String content;

    private Board board;
}
