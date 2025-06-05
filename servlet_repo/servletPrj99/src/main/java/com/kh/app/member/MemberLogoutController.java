package com.kh.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/logout")
public class MemberLogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getSession().removeAttribute("loginMember");
		// removeAttribute 로 로그아웃 시킬 수 있음.. 일정 시간 만료되면 세션 만료된 것 처럼 로그아웃 시킬 수 있음
		req.getSession().invalidate(); // 세션만료처리 : 세션에 있던 모든 정보가 사라지게 됨
		resp.sendRedirect("/home");
	}
	
}
