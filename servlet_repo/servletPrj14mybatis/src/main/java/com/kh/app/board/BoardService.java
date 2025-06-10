package com.kh.app.board;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.db.JDBCTemplate;
import com.kh.app.mybatis.SqlSessionTemplate;

public class BoardService {
	
	private BoardDao dao = new BoardDao();
	
	public int insert(BoardVo vo) throws Exception {
		//conn == ss
		SqlSession ss = SqlSessionTemplate.getSqlSession(); 
		//dao
		int result = dao.insert(ss, vo);
		//tx
		if(result == 1) {
			ss.commit();
		} else {
			ss.rollback();
		}
		//close
		ss.close();
		return result;
	}

//	public int insert(BoardVo vo) throws Exception {
//		//conn
//		Connection conn = JDBCTemplate.getConn();
//		//dao
//		int result = dao.insert(conn, vo);
//		//tx
//		if (result != 1) {
//			conn.rollback();
//		} else {
//			conn.commit();
//		}
//		
//		//close
//		conn.close();
//		return result;
//	}

	public List<BoardVo> selectList() throws Exception {
		//conn =>ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		//dao
		List<BoardVo> voList = dao.selectList(ss);
		
		//close
		ss.close();
		return voList;
		
	}
//	public List<BoardVo> selectList() throws Exception {
//		Connection conn = JDBCTemplate.getConn();
//		List<BoardVo> voList = dao.selectList(conn);
//		conn.close();
//		return voList;
//		
//	}

}
