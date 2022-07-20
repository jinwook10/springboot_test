package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.dto.Member_dto;

@Mapper
public interface MemberMapper {
	
	List<Member_dto> allmember();
}