package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.Member_dto;

@Service
public interface Member_service {
	public List<Member_dto> memberlist();
}
