package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.dto.Member_dto;
import com.example.service.Another_Member_serviceimpl;
//import com.example.service.Another_Member_serviceimpl;
import com.example.service.Test_Member_serviceimpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final Test_Member_serviceimpl tmService;
	private final Another_Member_serviceimpl amService;
	//private final Member_service amService;
	
	@RequestMapping(value = "/index2")
	public String index2(Model model) throws Exception {
		List<Member_dto> tmemlist = tmService.memberlist();
		List<Member_dto> amemlist = amService.memberlist();
		model.addAttribute("tmlist", tmemlist);
		System.out.println(tmemlist+"뭐야");
		model.addAttribute("amlist", amemlist);
		System.out.println(amemlist);
		return "index2";
	}
	
	@ResponseBody	//데이터를보냄 
	@RequestMapping(value = "/index3")
	public Object index3(Model model) throws Exception {
		Member_dto m = new Member_dto();
		m.setMem_age(10);
		m.setMem_id("abc");
		m.setMem_name("jinwok");
		return m;
	}
}
