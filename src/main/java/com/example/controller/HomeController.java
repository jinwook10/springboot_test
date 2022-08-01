package com.example.controller;

import com.example.model.Member;
import com.example.service.Impl.TestMemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final TestMemberServiceImpl tmService;
	private final PasswordEncoder passwordEncoder;
	@RequestMapping(value = "/")
	public String home() throws Exception {

		return "index";
	}

	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "exception", required = false) String exception,
						Model model){
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "login";
	}

	@GetMapping("/signup")
	public String signup(){
		return "admin/signup";
	}

	@PostMapping("/signup")
	public String signup(String username, String password){
		tmService.signup(username, passwordEncoder.encode(password));
		System.out.println("회원가입");
		return "redirect:/login";
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
		model.addAttribute("tmlist", tmemlist);
		System.out.println(tmemlist+"뭐야");
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
