package com.kh.app.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	public int insert(SqlSession ss, BoardVo vo) {
	    System.out.println("BoardDao.insert() 시작");
	    System.out.println("SQL 실행: BoardMapper.write");

	    int result = ss.insert("BoardMapper.write", vo);

	    System.out.println("SQL 실행 완료, 결과: " + result);
	    System.out.println("BoardDao.insert() 종료");
	    return result;
	}

	public List<BoardVo> selectList(SqlSession ss) {
		//SQL
		//close
		return ss.selectList("BoardMapper.getBoardList");
	
	}

}
