package com.example.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileData {
    private int id;
    private int boardNum;
    private String originalName;
    private String randomName;
    private LocalDateTime regDate;
}
