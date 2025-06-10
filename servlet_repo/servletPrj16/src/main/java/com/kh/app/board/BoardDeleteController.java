package com.kh.app.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			//data
			String no =	req.getParameter("no");
			//service
			BoardService boardService = new BoardService();
			int result = boardService.delete(no);
			//result
			PrintWriter out = resp.getWriter();
			out.write("result : " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
