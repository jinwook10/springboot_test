package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.another.AnotherMemberMapper;
import com.example.model.Member;
import com.example.service.MemberService;

@Service
public class AnotherMemberServiceImpl implements MemberService{
	
	@Autowired
	private AnotherMemberMapper memberMapper;
	
	@Override
	public List<Member> memberList() {
		List<Member> memlist = memberMapper.allMember();
		return memlist;
	}

}
