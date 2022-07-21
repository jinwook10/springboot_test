package com.example.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Member;
import com.example.service.Impl.AnotherMemberServiceImpl;
import com.example.service.Impl.TestMemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final TestMemberServiceImpl tmService;
	private final AnotherMemberServiceImpl amService;
	//private final Member_service amService;
	
	@RequestMapping(value = "/index2")
	public String index2(Model model) throws Exception {
		List<Member> tmemlist = tmService.memberList();
		List<Member> amemlist = amService.memberList();
		model.addAttribute("tmlist", tmemlist);
		System.out.println(tmemlist+"뭐야");
		model.addAttribute("amlist", amemlist);
		System.out.println(amemlist);
		return "index2";
	}
	
	@ResponseBody	//데이터를보냄 
	@RequestMapping(value = "/index3")
	public Object index3(Model model) throws Exception {
		Member m = new Member();
		m.setMem_age(10);
		m.setMem_id("abc");
		m.setMem_name("jinwok");
		return m;
	}
}