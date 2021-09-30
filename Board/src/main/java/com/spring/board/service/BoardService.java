package com.spring.board.service;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Board> searchPageBoards(String search, Integer pageNum) {
        //검색
        Page<Board> pageSearchBoardList = boardRepository.
                findByTitleContaining(search, PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));
        Page<Board> pageAllBoardList = null;
        List<Board> boards = null;
        List<Board> boardList = new ArrayList<>();

        //search
        boards = pageSearchBoardList.getContent();

        //All
        if (boards.isEmpty()) {
            pageAllBoardList = boardRepository.findAll
                    (PageRequest.of(pageNum - 1, PAGE_POST_COUNT, Sort.by(Sort.Direction.DESC, "id")));
            boards = pageAllBoardList.getContent();
        }

        for (Board board : boards) {
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

    public int getSearchBoardCount(String search) {
        return boardRepository.findByTitleContaining(search).size();
    }

    public Integer[] getPageList(String search, Integer curPageNum) {
        Integer[] pageList = new Integer[BLOCK_PAGE_NUM_COUNT];

        //총 게시글 수
        Double boardsTotalCount = null;

        //검색된 게시글 수
        if (Objects.equals(search, ""))
            boardsTotalCount = Double.valueOf(this.getBoardCount());
        else
            boardsTotalCount = (double) this.getSearchBoardCount(search);

        //총 게시글 수 기준으로 마지막 페이지 번호 올림
        Integer totalLastPageNum = (int) (boardsTotalCount / PAGE_POST_COUNT + 1);

        //페이지 시작 번호
        int blockNum = (int)Math.floor((curPageNum-1)/ BLOCK_PAGE_NUM_COUNT);
        curPageNum  = (BLOCK_PAGE_NUM_COUNT * blockNum) + 1;

        //현재 페이지를 기준으로 블럭의 마지막 페이지 번호
        Integer blockLastPageNum = curPageNum + BLOCK_PAGE_NUM_COUNT - 1;
        blockLastPageNum = totalLastPageNum < blockLastPageNum ? totalLastPageNum : blockLastPageNum;

        //페이지 번호 할당
        for (int i = curPageNum, idx = 0; i <= blockLastPageNum; i++, idx++) {
            pageList[idx] = i;
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
