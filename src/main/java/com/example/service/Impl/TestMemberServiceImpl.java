package com.example.service.Impl;

import com.example.mapper.test.MemberMapper;
import com.example.mapper.test.UserAuthMapper;
import com.example.model.Member;
import com.example.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TestMemberServiceImpl implements MemberService {

	private final MemberMapper memberMapper;
	private final UserAuthMapper userAuthMapper;

	
	@Override
	public List<Member> memberList() {
		List<Member> memlist = memberMapper.allMember();
		return memlist;
	}

	@Override
	public void signup(String username, String password) {
		userAuthMapper.signup(username, password);
	}

}
