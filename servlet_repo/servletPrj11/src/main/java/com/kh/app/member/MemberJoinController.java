package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {
	
	//회원가입 화면
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	}
	
	//회원가입 로직

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userNick = req.getParameter("userNick");
		
		System.out.println(userId);
		System.out.println(userPwd);
		System.out.println(userNick);
		System.out.println("회원가입 완료");
		
		//service
		int result = 1;
		//result
		HttpSession session = req.getSession();
		session.setAttribute("msg", "회원가입 성공 !!! ");
		resp.sendRedirect("/app/home");
	}

}