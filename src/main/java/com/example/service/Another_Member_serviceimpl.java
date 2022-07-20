package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Member_dto;
import com.example.mapper.another.AnotherDataBaseMapper;

@Service
public class Another_Member_serviceimpl implements Member_service{
	
	@Autowired
	private AnotherDataBaseMapper am;
	
	@Override
	public List<Member_dto> memberlist() {
		List<Member_dto> memlist = am.a_allmember();
		return memlist;
	}

}
