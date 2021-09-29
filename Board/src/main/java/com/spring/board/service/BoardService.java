package com.spring.board.service;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> searchBoardList(Pageable pageable, String search) throws Exception {
        List<Board> boardList = boardRepository.findAll();
        Page<Board> searchBoardList = null;
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                boardList.size() / 10 + 1,
                Sort.Direction.DESC,
                "title");

        if (!Objects.equals(search, "") && search != null)
            searchBoardList = boardRepository.findAllByTitleContaining(search, pageable);
        else
            searchBoardList = boardRepository.findAll(pageable);
        return searchBoardList;
    }

}
