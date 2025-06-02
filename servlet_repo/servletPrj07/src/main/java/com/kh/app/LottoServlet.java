package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lotto")
public class LottoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 데이터 꺼내기
		// 로직 : 랜덤 숫자 6개 준비
		int num1 = (int)(Math.random() * 45 + 1);
		int num2 = (int)(Math.random() * 45 + 1);
		int num3 = (int)(Math.random() * 45 + 1);
		int num4 = (int)(Math.random() * 45 + 1);
		int num5 = (int)(Math.random() * 45 + 1);
		int num6 = (int)(Math.random() * 45 + 1);
		
		req.setAttribute("n1", num1);
		req.setAttribute("n2", num2);
		req.setAttribute("n3", num3);
		req.setAttribute("n4", num4);
		req.setAttribute("n5", num5);
		req.setAttribute("n6", num6);
		// 결과
		req.getRequestDispatcher("/lotto.jsp").forward(req, resp);		
	}
	
}
