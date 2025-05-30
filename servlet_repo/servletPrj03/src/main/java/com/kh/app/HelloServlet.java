package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") // 웹서블릿 애너테이션
public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("한국어 테스트~");
		
		String x = req.getParameter("userNick");
		
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = resp.getWriter();

		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<style>");
		pw.println("body{");
		pw.println("background : #c0c0c0;");
		pw.println("}");
		pw.println("h1:hover{");
		pw.println("background-color : #242424;");
		pw.println("color : #fff;");
		pw.println("}");
		pw.println("</style>");
		pw.println("</head>");
		
		pw.println("<body>");
		pw.println("<h1>안녕하세요</h1>");
		pw.println("<h2>" + x + " 님</h2>");
		pw.println("</body>");
		
		pw.println("</html>");
		
	}
}
