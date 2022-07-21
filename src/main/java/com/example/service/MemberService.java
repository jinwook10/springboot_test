package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Member;

@Service
public interface MemberService {
	public List<Member> memberList();
}
