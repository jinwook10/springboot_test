package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.dto.Member_dto;
import com.example.mapper.test.TestDataBaseMapper;

@Primary
@Service
public class Test_Member_serviceimpl implements Member_service {
	
	@Autowired
	private TestDataBaseMapper tm;
	
	@Override
	public List<Member_dto> memberlist() {
		List<Member_dto> memlist = tm.t_allmember();
		return memlist;
	}

}
