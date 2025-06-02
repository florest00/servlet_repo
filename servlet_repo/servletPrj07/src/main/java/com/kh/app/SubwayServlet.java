package com.kh.app;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/subway")
public class SubwayServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// data : age
		int age = Integer.parseInt(req.getParameter("age"));
		// calc subway fee
		int fee = 0;
		if(age < 13) {
			fee = 500;
		}else if (age < 20) {
			fee = 1000;
		} else {
			fee = 1500;
		}
		req.setAttribute("fee", fee);
		req.setAttribute("age", age);
		// result
		if(age >= 0) {
			req.getRequestDispatcher("/subway.jsp").forward(req, resp);
		}else {
			req.setAttribute("errorMsg", "age는 음수일 수 없습니다.");
			req.getRequestDispatcher("/error.jsp").forward(req, resp);
		}
		
	
	}
	
}
