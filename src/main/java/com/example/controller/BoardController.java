package com.example.controller;

import com.example.model.BoardDetails;
import com.example.model.CustomUserDetails;
import com.example.model.FileData;
import com.example.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/board")
    public String board(Model model, BoardDetails boardDetails) {
        List<BoardDetails> list = boardService.listAll(boardDetails);
        model.addAttribute("list", list);
        return "board/board";
    }

    @GetMapping("/write")
    public String write(Model model, Authentication auth) {
        model.addAttribute("user", ((CustomUserDetails) auth.getPrincipal()).getName());
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String write(String title, String content, Authentication auth, @RequestParam("file") MultipartFile files) {
        BoardDetails boardDetails = new BoardDetails();
        boardDetails.setTitle(title);
        boardDetails.setContent(content);
        boardDetails.setWriter(((CustomUserDetails) auth.getPrincipal()).getName());
        boardService.write(boardDetails);
        System.out.println(boardDetails.getId());
        //int boardNo = boardService.id();
        if (files.getSize() != 0) {
            System.out.println("파일있다");
            FileData fileData = new FileData();
            String filename = files.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
//            String extension = filename.substring(filename.lastIndexOf("."), filename.length());
            String randomname = uuid.toString();
            try {
                byte[] filedata = files.getBytes();
//아래는 집                FileOutputStream outputStream = new FileOutputStream("C:/Users/cyder/FileTest/" + randomname);
                FileOutputStream outputStream = new FileOutputStream("C:/Users/jinwook/테스트용/" + randomname);
                outputStream.write(filedata);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileData.setOriginalName(filename);
            fileData.setRandomName(randomname);
            fileData.setBoardNum(boardDetails.getId());
            boardService.fileSave(fileData);
        }

        System.out.println("이름" + files.getName());
        System.out.println("크기" + files.getSize());
        System.out.println("원래이름" + files.getOriginalFilename());

        return "redirect:/board";
    }
    @GetMapping("/filedown")
    public void download(HttpServletResponse response, @RequestParam("no") String no) throws Exception {

        try {
            String filename = (boardService.down(no)).getRandomName();
            String fileOname = (boardService.down(no)).getOriginalName(); //원래이름으로 바꿔주기 위함

//            System.out.println(filename);
            String path = "C:\\Users\\jinwook\\테스트용\\" + filename;
//            System.out.println(path);
            File file = new File(path);
            response.setHeader("Content-Disposition", "attachment; filename=" + fileOname); // 다운로드 되거나 로컬에 저장되는 용도로 쓰이는지를 알려주는 헤더

            FileInputStream fileInputStream = new FileInputStream(path); // 파일 읽어오기
            OutputStream out = response.getOutputStream();

            int read = 0;
            byte[] buffer = new byte[1024];
            while ((read = fileInputStream.read(buffer)) != -1) { // 1024바이트씩 계속 읽으면서 outputStream에 저장, -1이 나오면 더이상 읽을 파일이 없음
                out.write(buffer, 0, read);
            }
            out.flush();
        } catch (Exception e) {
            throw new Exception("download error");
        }
    }

    @GetMapping("/view")
    public String view(@RequestParam("no") String no, Model model) {
        BoardDetails boardDetails = boardService.viewDetail(no);
        int fileNo = boardService.viewfile(no);

        model.addAttribute("bd", boardDetails);
        model.addAttribute("f", fileNo);
        return "board/boardDetail";
    }
}
