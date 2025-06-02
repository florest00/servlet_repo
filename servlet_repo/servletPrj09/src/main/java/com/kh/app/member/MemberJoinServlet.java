package com.kh.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/join")
public class MemberJoinServlet extends HttpServlet {
	// 원래는 MemberJoinViewServlet, MemberJoinProcessServlet 따로였는데 합쳐짐
	
	// 회원가입(화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		PrintWriter out = resp.getWriter();
		
		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
		
		
	}
	
	// 회원가입(로직)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//data 꺼내오기
		String userId = req.getParameter("userId");
		String userPwd = req.getParameter("userPwd");
		String userNick = req.getParameter("userNick");
		
		//service (트랜잭션, fl?)
//		int result = 서비스객체.insert(데이터);
		int result = 1;

		//result
		if(result != 1) {
			req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/views/member/joinSuccess.jsp").forward(req, resp);
	}
}
