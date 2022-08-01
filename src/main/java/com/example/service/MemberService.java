package com.example.service;

import com.example.model.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
	public List<Member> memberList();
	public void signup(String username, String password);

}
