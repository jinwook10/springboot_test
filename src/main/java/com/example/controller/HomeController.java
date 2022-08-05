package com.example.controller;

import com.example.model.Member;
import com.example.model.UserDetail;
import com.example.service.Impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

	private final Logger logger = LogManager.getLogger(HomeController.class);
	private final MemberServiceImpl tmService;
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
		logger.info("test");
		return "signup";
	}

	@PostMapping("/signup")
	public String signup(String username, String password){
		tmService.signup(username, passwordEncoder.encode(password));
		System.out.println("회원가입");
		return "redirect:/login";
	}

	@GetMapping(value = "/admin/adminpage")
	public String adminpage() throws Exception {
		return "admin/AdminPage";
	}
	@GetMapping(value = "/admin/notice")
	public String notice() throws Exception {

		return "admin/NoticeWrite";
	}

	@GetMapping(value = "/admin/member")
	public String member() throws Exception {
		return "admin/Member";
	}

	@GetMapping("/admin/getMembers")
	@ResponseBody
	public Object getMembers() {
		List<UserDetail> list = tmService.listAll();
		HashMap<String, Object> map = new HashMap<>();
		map.put("data", list);
		return map;
	}

	@ResponseBody	//데이터를보냄
	@GetMapping(value = "/index3")
	public Object index3(Model model) throws Exception {
		Member m = new Member();

		m.setMem_age(10);
		m.setMem_id("abc");
		m.setMem_name("jinwok");
		logger.warn("로거테스트");
		logger.error("로거테스트");
		logger.fatal("로거테스트");
		return m;
	}
}
