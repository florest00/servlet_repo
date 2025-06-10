package com.kh.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/quit")
// annotation => url mapping
public class MemberQuitController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// 데이터 받아와서 doPost
		
		try {
			//data
			req.setCharacterEncoding("UTF-8");
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			
			// 데이터 꺼내오고 데이터를 뭉쳐주고
			MemberVo vo = new MemberVo();
			vo.setUserId(userId);
			vo.setUserPwd(userPwd);
			
			//service
			MemberService memberService = new MemberService();
			int result = memberService.quit(vo);
			// 실행결과 int로 받아준다
			
			//result
			PrintWriter out = resp.getWriter();
			out.write("result :" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
