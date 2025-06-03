package com.kh.app.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	//게시글 목록 화면
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//service객체.selectList();
		List<BoardVo> voList = new ArrayList<>();
		
//		BoardVo x = new BoardVo("제목01", "내용01");
		voList.add( new BoardVo("제목01", "내용01"));
		voList.add( new BoardVo("제목02", "내용02"));
		voList.add( new BoardVo("제목03", "내용03"));
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/board/list.jsp").forward(req, resp);
		
	}
}
