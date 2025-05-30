package com.kh.app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello") // value -> default, "/" 빠트리지 x
public class HelloServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("zzz");
		PrintWriter pw = resp.getWriter();
		pw.println( "<html>" ); //pw 외부의 다른 프로세스에 연결
		pw.println( "<html lang='ko'>" );
		pw.println( "<h1>한국어 테스트~~~</h1>" );
		pw.println( "</html>" );
	}
	
}
