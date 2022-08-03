package com.example.mapper.test;

import com.example.model.Member;
import com.example.model.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
	List<Member> allMember();

	List<UserDetail> listAll();
}
