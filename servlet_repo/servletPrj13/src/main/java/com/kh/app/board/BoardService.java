package com.kh.app.board;

import java.sql.Connection;
import java.util.List;

import com.kh.app.db.JDBCTemplate;

public class BoardService {

	private BoardDao boardDao = new BoardDao();

	public int insert(BoardVo vo) throws Exception {
		// biz
		// conn
		Connection conn = JDBCTemplate.getConn();
		// dao
		int result = boardDao.insert(conn, vo);
		// tx
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		// close
		conn.close();
		return result;
	}

	public List<BoardVo> selectList() throws Exception {
		//conn
		Connection conn = JDBCTemplate.getConn();
		//dao
		List<BoardVo> voList = boardDao.selectList(conn);
		
		//close
		conn.close();
		return voList;
	
	}

}
