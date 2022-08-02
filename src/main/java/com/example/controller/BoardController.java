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

import java.io.FileOutputStream;
import java.io.IOException;
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
                FileOutputStream outputStream = new FileOutputStream("C:/Users/cyder/FileTest/" + randomname);
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

    @GetMapping("/view")
    public String view(@RequestParam("no") String no, Model model) {
        BoardDetails boardDetails = boardService.viewDetail(no);
        model.addAttribute("bd", boardDetails);
        return "board/boardDetail";
    }
}
