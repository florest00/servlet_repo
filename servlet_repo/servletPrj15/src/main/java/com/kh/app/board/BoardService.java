package com.kh.app.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.MybatisTemplate;

public class BoardService {

	private final BoardDao dao = new BoardDao();
	
	public int insert(BoardVo vo) throws Exception {
	    System.out.println("BoardService.insert() 시작");

	    System.out.println("SqlSession 열기");
	    SqlSession ss = MybatisTemplate.getSqlSession();

	    System.out.println("DAO insert 호출");
	    int result = dao.insert(ss, vo);
	    System.out.println("DAO insert 완료, 결과: " + result);

	    System.out.println("커밋 시작");
	    ss.commit();
	    System.out.println("커밋 완료");

	    System.out.println("세션 종료");
	    ss.close();

	    System.out.println("BoardService.insert() 종료");
	    return result;
	}

	public List<BoardVo> selectList() throws Exception {
		//conn => ss
		SqlSession ss = MybatisTemplate.getSqlSession();
		//dao
		List<BoardVo> voList = dao.selectList(ss);
		
		//tx
		ss.commit();
		
		ss.close();
		
		return voList;
	}

}
