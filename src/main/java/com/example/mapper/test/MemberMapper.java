package com.example.mapper.test;

import com.example.model.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
	List<Member> allMember();
}
