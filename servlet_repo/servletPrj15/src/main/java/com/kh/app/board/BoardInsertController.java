package com.kh.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/insert")
public class BoardInsertController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    System.out.println("doPost 시작");

	    try {
	        System.out.println("요청 인코딩 설정 시작");
	        req.setCharacterEncoding("UTF-8");
	        System.out.println("요청 인코딩 설정 종료");

	        System.out.println("파라미터 수집 시작");
	        String title = req.getParameter("title");
	        String content = req.getParameter("content");
	        System.out.println("파라미터 수집 종료: title=" + title + ", content=" + content);

	        System.out.println("BoardVo 객체 생성 시작");
	        BoardVo vo = new BoardVo();
	        vo.setTitle(title);
	        vo.setContent(content);
	        System.out.println("BoardVo 객체 생성 종료");

	        System.out.println("서비스 insert 호출 시작");
	        BoardService boardService = new BoardService();
	        int result = boardService.insert(vo);
	        System.out.println("서비스 insert 호출 종료, 결과: " + result);

	        if (result != 1) {
	            System.out.println("결과가 1이 아님 → 예외 발생");
	            throw new Exception();
	        } else {
	            System.out.println("정상 등록 완료 → list로 리다이렉트");
	            resp.sendRedirect("/board/list");
	        }
	    } catch (Exception e) {
	        System.out.println("예외 발생: " + e.getMessage());
	        e.printStackTrace();
	        System.out.println("에러 페이지로 리다이렉트");
	        resp.sendRedirect("/error");
	    }

	    System.out.println("doPost 종료");
	}
}
