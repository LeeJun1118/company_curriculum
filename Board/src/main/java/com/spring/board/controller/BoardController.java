package com.spring.board.controller;

import com.spring.board.domain.Board;
import com.spring.board.repository.BoardRepository;
import com.spring.board.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
public class BoardController {

    private final BoardRepository boardRepository;
    private final BoardService boardService;

    public BoardController(BoardRepository boardRepository, BoardService boardService) {
        this.boardRepository = boardRepository;
        this.boardService = boardService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Board> boardList = boardRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("boardList", boardList);
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "search")String search, Model model){
        List<Board> boardList = boardService.searchBoards(search);
        model.addAttribute("boardList",boardList);
        return "index";
    }
    /*    @GetMapping("/")
        public String list(@RequestParam("search") String search,
                           Model model, Pageable pageable) throws Exception {
            Page<Board> boardList = boardService.searchBoardList(pageable, search);
            model.addAttribute("boardList", boardList);
            return "index";
        }*/
    /*@GetMapping("/list")
    public String list(@RequestParam(value = "search", defaultValue = "") String search,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       Model model, Pageable pageable) throws Exception {
        Page<Board> boardList = null;
        if (Objects.equals(search, ""))
            boardList = boardRepository.findAll(pageable);
        else
            boardList = boardRepository.findAllByTitleContaining(search, pageable);
        int pageCount = boardList.getTotalPages();
        int[] pages = new int[pageCount];
        for (int i = 0; i < pageCount; i++) {
            pages[i] = i;
        }
        model.addAttribute("pages", pages);
        model.addAttribute("pagesCurrent", page);
        model.addAttribute("search", search);


        model.addAttribute("boardList", boardList);
        return "index";
    }*/

    @GetMapping("/board/{id}")
    public String showBoard(@PathVariable("id") Long id, Model model) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        model.addAttribute("board", board);

        return "boards/showBoard";
    }

    @GetMapping("/board/new")
    public String boardForm(Model model) {
        model.addAttribute("boardForm", new BoardForm());
        return "boards/newBoard";
    }

    @PostMapping("/board/new")
    public String createBoard(@Valid BoardForm boardForm, BindingResult result) {
        if (result.hasErrors()) {
            return "boards/newBoard";
        }
        Board board = new Board();
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        board.setFilename(boardForm.getFilename());
        boardRepository.save(board);
        return "redirect:/board/" + board.getId();
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
        board.setFilename(boardForm.getFilename());

        boardRepository.save(board);
        return "redirect:/board/" + board.getId();
    }
}
