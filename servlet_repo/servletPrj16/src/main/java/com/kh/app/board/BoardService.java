package com.kh.app.board;

import java.io.PrintWriter;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.mybatis.SqlSessionTemplate;

public class BoardService {

	private final BoardDao dao = new BoardDao();
	
	public int insert(BoardVo vo) throws Exception {
		// 비즈니스 로직
		// 디비연결 conn => ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		// DAO 호출
		int result = dao.insert(ss, vo);
		// 트랜잭션 처리
		if(result != 1) {
			ss.rollback();
		} else {
			ss.commit();
		}
		// 자원 반납
		ss.close();
		return result;
	}

	public List<BoardVo> selectList() throws Exception {
		
		// conn => ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		// DAO 호출
		List<BoardVo> voList = dao.selectList(ss);
		
		// tx <= select하는거라 tx 필요 x
//		ss.commit();
		
		// close
		ss.close();
		
		return voList;
	}

	public BoardVo selectBoardByNo(String no) throws Exception {
		//biz
		//ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
//		조회수
		int result = dao.increaseHit(ss, no);
		//tx
		BoardVo vo = null;
		if(result == 1) {
			ss.commit();
			//DAO
			vo = dao.selectBoardByNo(ss, no);
		} else {
			ss.rollback();
		}
		//close
		ss.close();
		
		return vo;
	
	}

	public int edit(BoardVo vo) throws Exception {
		//biz
		//ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//dao
		int result = dao.edit(ss, vo);
		//tx
		if (result != 1) {
			ss.rollback();
		} else {
			ss.commit();
		}
		//close
		ss.close();
		return result;
	
	}

	public int delete(String no) throws Exception {
		//biz
		//ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//dao
		int result = dao.delete(ss, no);
		//tx
		if (result != 1) {
			ss.rollback();
		} else {
			ss.commit();
		}
		//close
		ss.close();
		return result;
	}

}
