package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// userId, userPwd 받기
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		
		// 복잡한 작업
		System.out.println("아이디, 비번 이용해서 DB 값 조회하고 로그인 성공 여부 판단");
		// admin, 1234 면 로그인 성공 취급하기
		req.setAttribute(userId, userPwd); //=> 담주..!
		
		// JSP 한테 처리 떠넘기기
		req.getRequestDispatcher("/hello.jsp").forward(req, resp);
	}
	
}
