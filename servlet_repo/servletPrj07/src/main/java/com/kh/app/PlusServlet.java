package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/plus")
public class PlusServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 숫자 2개 받아서 == 클라이언트가 보낸 데이터 꺼내기
		String a = req.getParameter("a");
		String b = req.getParameter("b");
		
		// 더하기
		int result = Integer.parseInt(a) + Integer.parseInt(b);
		
		// 결과 응답 (서블릿이 직접)
//		PrintWriter out = resp.getWriter();
//		out.println("<h1>" + result + "</h1>");
		
		req.setAttribute("x", result);
		
		// 결과 응답 (JSP한테 위임)
		req.getRequestDispatcher("/abc.jsp").forward(req, resp);
		
	}
	
}
