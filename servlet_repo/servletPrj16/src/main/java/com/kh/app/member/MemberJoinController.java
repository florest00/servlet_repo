package com.kh.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member/join")
public class MemberJoinController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//data
			req.setCharacterEncoding("UTF-8");
			String userId = req.getParameter("userId");
			String userPwd = req.getParameter("userPwd");
			String userNick = req.getParameter("userNick");
			
			MemberVo vo = new MemberVo();
			vo.setUserId(userId);
			vo.setUserPwd(userPwd);
			vo.setUserNick(userNick);
			
			//service
			MemberService memberService = new MemberService();
			int result = memberService.join(vo);
			
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
		
			if(result != 1) {
				throw new Exception();
			} else {
				req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
			//result
			resp.sendRedirect("/app/error");
		}
		
		//result
//		resp.sendRedirect("~");
//		req.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(req, resp);
	
	}
	
}
