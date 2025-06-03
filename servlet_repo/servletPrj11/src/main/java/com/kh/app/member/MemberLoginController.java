package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	// 로그인 화면
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(req, resp);
	
	}
	
	// 로그인 로직
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		//service
		int result = 1;
		//result
		req.getSession().setAttribute("msg", "로그인 성공 ~ !!!");
		resp.sendRedirect("/app/home");
		
		/*
		if( result != 1) {
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;
		}
		 * */
		
//		req.getRequestDispatcher("/WEB-INF/views/member/loginSuccess.jsp").forward(req, resp);
//		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	}
	
}
