package com.example.controller;

import com.example.model.Member;
import com.example.service.Impl.AnotherMemberServiceImpl;
import com.example.service.Impl.TestMemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final TestMemberServiceImpl tmService;
	private final AnotherMemberServiceImpl amService;
	@RequestMapping(value = "/")
	public String home() throws Exception {

		return "index";
	}

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "exception", required = false) String exception,
						Model model){
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "login";
	}

	@RequestMapping(value = "/admin/adminpage")
	public String adminpage() throws Exception {

		return "admin/AdminPage";
	}

	@RequestMapping(value = "/admin/notice")
	public String notice() throws Exception {

		return "admin/NoticeWrite";
	}

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
