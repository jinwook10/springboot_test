package com.example.mapper.test;

import com.example.model.BoardDetails;
import com.example.model.FileData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public void write(BoardDetails boardDetails);
    public void fileSave(FileData fileData);
    public List<BoardDetails> listAll(BoardDetails boardDetails);

    public BoardDetails viewDetail(String no);
}
