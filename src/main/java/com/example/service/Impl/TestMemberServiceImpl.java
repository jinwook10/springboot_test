package com.example.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.mapper.test.MemberMapper;
import com.example.model.Member;
import com.example.service.MemberService;

@Primary
@Service
public class TestMemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<Member> memberList() {
		List<Member> memlist = memberMapper.allMember();
		return memlist;
	}

}
