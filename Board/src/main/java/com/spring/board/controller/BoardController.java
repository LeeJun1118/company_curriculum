package com.spring.board.controller;

import com.spring.board.domain.Board;
import com.spring.board.domain.MyFile;
import com.spring.board.domain.Reply;
import com.spring.board.repository.BoardRepository;
import com.spring.board.repository.MyFileRepository;
import com.spring.board.repository.ReplyRepository;
import com.spring.board.service.BoardService;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.List;
import java.util.Locale;


@Controller
@AllArgsConstructor
public class BoardController {

    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;
    private final MyFileRepository myFileRepository;

    private final BoardService boardService;
    //블럭에 존재하는 페이지 번호 수
    private static final int BLOCK_PAGE_NUM_COUNT = 3;

    @GetMapping("/")
    public String list() {
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String search(Model model,
                         @RequestParam(value = "search", defaultValue = "") String search,
                         @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
        List<Board> boardList = boardService.searchPageBoards(search, pageNum);
        Integer[] pageList = boardService.getPageList(search, pageNum);
        int maxPage = boardService.getSearchBoardCount(search) / 10 + 1;
        int nextPage = 1;
        int prevPage = 1;

        //다음 페이지
        if (pageList[0] != null)
            Math.max(maxPage, pageList[0] + 3);

        //이전 페이지
        if (pageList[0] != null && pageList[0] > 1)
            prevPage = pageList[0] - 1;
        if (pageNum > BLOCK_PAGE_NUM_COUNT)
            prevPage = pageNum - (pageNum % BLOCK_PAGE_NUM_COUNT);

        model.addAttribute("prevPage", prevPage);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("maxPage", maxPage);
        model.addAttribute("search", search);
        model.addAttribute("curPage", pageNum);
        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);

        return "index";
    }

    @GetMapping("/board/{id}")
    public String showBoard(@PathVariable("id") Long id, Model model) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);

        List<Reply> replyList = replyRepository.findAllByBoard(board);
        model.addAttribute("replyList", replyList);

        List<MyFile> myFileList = myFileRepository.findAllByBoard(board);
        model.addAttribute("myFileList", myFileList);

        return "boards/showBoard";
    }

    @GetMapping("/board/new")
    public String boardForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "boards/newBoard";
    }

    @PostMapping("/board/new")
    public String createBoard(@Valid BoardForm boardForm, BindingResult result,
                              @RequestParam(value = "uploadFile", required = false) List<MultipartFile> files) throws Exception {

        if (result.hasErrors()) {
            return "boards/newBoard";
        }
        /*if (!files.isEmpty()) {
            boardRepository.save(board);
            return "redirect:/board/" + board.getId();
        } else {
            //boardService.uploadFile(board, files);
            return "redirect:/board/" + boardService.uploadFile(board, files);
        }*/
        return "redirect:/board/" + boardService.uploadFile(boardForm, files);
    }

    @GetMapping("/board/delete/{id}")
    public String deleteBoard(@PathVariable("id") Long id) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board Id : " + id));
        boardRepository.delete(board);
        return "redirect:/";
    }

    @GetMapping("/board/update/{id}")
    public String updateBoardForm(@PathVariable("id") Long id, Model model) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);
        return "boards/updateBoard";
    }

    @PostMapping("/board/update/{id}")
    public String updateBoard(@PathVariable("id") Long id, @Valid BoardForm boardForm, BindingResult result) {
        if (result.hasErrors()) {
            return "boards/updateBoard";
        }
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id : " + id));
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        //board.setFilename(boardForm.getFilename());

        boardRepository.save(board);
        return "redirect:/board/" + board.getId();
    }
}
