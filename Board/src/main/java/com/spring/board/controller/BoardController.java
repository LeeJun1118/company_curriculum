package com.spring.board.controller;

import com.spring.board.domain.Board;
import com.spring.board.domain.MyFile;
import com.spring.board.domain.Reply;
import com.spring.board.repository.BoardRepository;
import com.spring.board.repository.MyFileRepository;
import com.spring.board.repository.ReplyRepository;
import com.spring.board.service.BoardService;

import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

@Controller
@AllArgsConstructor
public class BoardController {

    @Autowired
    ResourceLoader resourceLoader;

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

        String myFileName = null;
        if (myFileList.size() >= 1) {
            myFileName = myFileList.get(0).getOriginFileName();
            model.addAttribute("myFileName", myFileName);
        }

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
    public String updateBoard(@PathVariable("id") Long id, @Valid BoardForm boardForm,
                              @RequestParam(value = "uploadFile", required = false) List<MultipartFile> files,
                              BindingResult result) throws Exception {
        if (result.hasErrors()) {
            return "boards/updateBoard";
        }
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id : " + id));

        //DB에 저장된 파일 불러오기
        List<MyFile> dbFileList = myFileRepository.findAllByBoard(board);

        //전달된 파일
        List<MultipartFile> multipartFileList = files;
        System.out.println(multipartFileList.toString());

        //새롭게 전달된 파일들의 목록을 저장할 List
        List<MultipartFile> addFileList = new ArrayList<>();

        //DB에 없다면
        if (CollectionUtils.isEmpty(dbFileList)) {
            //전달된 파일이 하나라도 있다면
            multipartFileList.forEach(f -> {
                if (f.getSize() > 0)
                    for (MultipartFile multipartFile : multipartFileList)
                        //저장할 파일 목록에 추가
                        addFileList.add(multipartFile);

            });
        }
        //DB에 파일이 하나 이상 존재한다면
        else {
            //전달된 파일이 아예 없다면
            multipartFileList.forEach(f -> {
                if (f.getSize() <= 0)
                    for (MyFile file : dbFileList)
                        myFileRepository.deleteById(file.getId());
                else {
                    //DB에 저장된 파일 원본명 목록
                    List<String> dbOriginNameList = new ArrayList<>();
                    System.out.println("dbOriginNameList ==="+dbOriginNameList.toString());

                    //DB의 파일 원본명 추출
                    for (MyFile myFile : dbFileList) {
                        //File id 로 DB에 저장된 파일 정보 얻기
                        MyFile file = myFileRepository.findById(myFile.getId())
                                .orElseThrow(() -> new IllegalArgumentException("Invalid file Id : " + myFile.getId()));

                        //DB의 파일 원본명
                        String dbOriginFileName = file.getOriginFileName();

                        //서버에 저장된 파일 중 전달된 파일이 존재하지 않으면 삭제 그게 아니면 DB에 저장할 파일 목록에 추가
                        AtomicBoolean deleteOrAdd = new AtomicBoolean(false);
                        multipartFileList.forEach(mlist -> {
                            for (MultipartFile mf : multipartFileList) {
                                if (Objects.equals(mf.getOriginalFilename(), dbOriginFileName))
                                    deleteOrAdd.set(true);
                            }
                        });
                        if (deleteOrAdd.get())
                            myFileRepository.delete(myFile);
                        else{
                            myFileRepository.delete(myFile);
                            dbOriginNameList.add(dbOriginFileName);
                        }

                    }

                    //전달된 파일 하나씩 검사
                    for (MultipartFile multipartFile : multipartFileList) {
                        //파일의 원본명 얻기
                        String multipartOriginName = multipartFile.getOriginalFilename();
                        //DB에 없는 파일이면
                        if (!dbOriginNameList.contains(multipartOriginName)) {
                            //DB에 저장할 파일 목록 추가
                            addFileList.add(multipartFile);
                        }
                    }
                }
            });

        }

        boardService.update(id, boardForm, addFileList);

        //boardRepository.save(board);
        return "redirect:/board/" + id;
    }

    @GetMapping("/board/download/{id}")
    public void download(@PathVariable("id") Long id,
                         HttpServletResponse response) throws IOException {
        String absolutePath = new File("").getAbsolutePath() + File.separator + File.separator;
        Board board = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid board Id:" + id));
        List<MyFile> myFileList = myFileRepository.findAllByBoard(board);
        String filePath  = absolutePath + myFileList.get(0).getFilePath();

        byte[] fileByte = FileUtils.readFileToByteArray(new File(filePath));

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(myFileList.get(0).getOriginFileName(), "UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");

        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }
}
