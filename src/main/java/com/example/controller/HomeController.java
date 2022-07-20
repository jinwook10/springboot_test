package com.example.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Member_dto;
import com.example.mapper.MemberMapper;

@Controller
public class HomeController {
//	private static final String DRIVER = "org.mariadb.jdbc.Driver";
//	private static final String URL = "jdbc:mariadb://localhost:3306/test";
//	private static final String USER = "jinwook";
//	private static final String PASSWORD = "1234";
	
	
	
	@RequestMapping(value = "/index2")
	public String index2(Locale locale, Model model) throws Exception {
//		testConnection();
		
		return "index2";
	}
//	public void testConnection() throws Exception {
//        // DBMS에게 DB 연결 드라이버의 위치를 알려주기 위한 메소드
//        Class.forName(DRIVER);
//        try {
//            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//            System.out.println(connection);
//            System.out.println("연결성공");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
