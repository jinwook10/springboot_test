package com.example.service.Impl;

import com.example.mapper.test.BoardMapper;
import com.example.model.BoardDetails;
import com.example.model.FileData;
import com.example.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public void write(BoardDetails boardDetails) {
        boardMapper.write(boardDetails);
    }

    @Override
    public void fileSave(FileData fileData) {
        boardMapper.fileSave(fileData);
    }

    @Override
    public List<BoardDetails> listAll() {
        return boardMapper.listAll();
    }

    @Override
    public BoardDetails viewDetail(String no) {
        return boardMapper.viewDetail(no);
    }

}
