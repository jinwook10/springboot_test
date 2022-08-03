package com.example.controller;

import com.example.model.BoardDetails;
import com.example.model.FileData;
import com.example.model.UserDetail;
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
    public String board(Model model) {
        List<BoardDetails> list = boardService.listAll();
        model.addAttribute("list", list);
        return "board/board";
    }

    @GetMapping("/write")
    public String write(Model model, Authentication auth) {
        model.addAttribute("user", ((UserDetail) auth.getPrincipal()).getName());
        return "board/writeForm";
    }

    @PostMapping("/write")
    public String write(String title, String content, Authentication auth, @RequestParam("file") MultipartFile files) {
        BoardDetails boardDetails = new BoardDetails();

        boardDetails.setTitle(title);
        boardDetails.setContent(content);
        boardDetails.setWriter(((UserDetail) auth.getPrincipal()).getName());
        boardService.write(boardDetails);

        if (files.getSize() != 0) {
            FileData fileData = new FileData();
            String filename = files.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
//            String extension = filename.substring(filename.lastIndexOf("."), filename.length());
            String randomname = uuid.toString();
            try {
                byte[] filedata = files.getBytes();
                FileOutputStream outputStream = new FileOutputStream("C:/Users/cyder/FileTest/" + randomname);
//                FileOutputStream outputStream = new FileOutputStream("C:/Users/jinwook/테스트용/" + randomname);
                outputStream.write(filedata);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileData.setOriginalName(filename);
            fileData.setRandomName(randomname);
            fileData.setBoardNum(boardDetails.getId());
            boardService.fileSave(fileData);
        }
        return "redirect:/board";
    }

    @GetMapping("/filedown")
    public void download(HttpServletResponse response, @RequestParam("no") String no) throws Exception {

        try {
            var fileData =  boardService.down(no);
            String filename = fileData.getRandomName(); //저장된 랜덤 이름
            String fileOname = fileData.getOriginalName(); //다운받을 원래 이름
            fileOname = new String(fileOname.getBytes("UTF-8"), "ISO-8859-1");  //크롬 파일이름 한글깨짐 해결

            System.out.println(fileData);
            String path = "C:\\Users\\cyder\\FileTest\\" + filename;
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
        Integer fileNo = boardService.viewfile(no);

        model.addAttribute("bd", boardDetails);
        model.addAttribute("f", fileNo);
        return "board/boardDetail";
    }
}
