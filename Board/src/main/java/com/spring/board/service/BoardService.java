package com.spring.board.service;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.Ingres9Dialect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    //블럭에 존재하는 페이지 번호 수
    private static final int BLOCK_PAGE_NUM_COUNT = 3;
    //한 페이지에 존재하는 게시글의 수
    private static final int PAGE_POST_COUNT = 10;

    public List<Board> searchBoards(String search) {
        List<Board> boardSearchList = boardRepository.findByTitleContaining(search);
        List<Board> boardList = new ArrayList<>();

        if (boardSearchList.isEmpty()) return boardList;

        for (Board board : boardSearchList) {
            boardList.add(this.convertEntityBoard(board));
        }

        return boardList;
    }

    public List<Board> getBoardList(Integer pageNum) {
        Page<Board> page = boardRepository.findAll
                (PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));

        List<Board> boards = page.getContent();
        List<Board> boardList = new ArrayList<>();
        for (Board board : boards) {
            boardList.add(this.convertEntityBoard(board));
        }

        return boardList;
    }

    public Long getBoardCount() {
        return boardRepository.count();
    }

    public Integer[] getPageList(Integer curPageNum) {
        //총 게시글 수
        Double boardsTotalCount = Double.valueOf(this.getBoardCount());

        //총 게시글 수 기준으로 마지막 페이지 번호
        Integer totalLastPageNum = (int) (Math.ceil(boardsTotalCount / PAGE_POST_COUNT));

        Integer[] pageList = new Integer[totalLastPageNum];

        //현재 페이지를 기준으로 블럭의 마지막 페이지 번호
        Integer blockLastPageNum = (totalLastPageNum > curPageNum + BLOCK_PAGE_NUM_COUNT)
                ? curPageNum + BLOCK_PAGE_NUM_COUNT
                : totalLastPageNum;

        //페이지 시작 번호
        curPageNum = (curPageNum <= 3) ? 1 : curPageNum - 2;

        //페이지 번호 할당
        for (int val = curPageNum, idx = 0; val <= blockLastPageNum; val++, idx++) {
            pageList[idx] = val;
        }

        return pageList;
    }

    private Board convertEntityBoard(Board board) {
        return Board.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .filename(board.getFilename())
                .build();
    }
}
