package com.example.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BoardDetails {
    private int id;
    private String title;
    private String content;
    private int read_cnt;
    private String writer;
    private LocalDateTime write_time;
    private LocalDateTime update_time;

}
