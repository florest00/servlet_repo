package com.kh.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/login")
public class MemberLoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// data
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");

			MemberVo vo = new MemberVo();
			vo.setUserId(userId);
			vo.setUserPwd(userPwd);

			// service
			MemberService memberService = new MemberService();
			MemberVo selectedMemberVo = memberService.login(vo);

			// result
			PrintWriter out = resp.getWriter();
			out.write(selectedMemberVo.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
