package com.example.service;

import com.example.model.BoardDetails;
import com.example.model.FileData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {
    public void write(BoardDetails boardDetails);
//    public void delete();
    public void fileSave(FileData fileData);

    public List<BoardDetails> listAll();

    public BoardDetails viewDetail(String no);

    public FileData down(String no);

    public Integer viewfile(String no);
}
