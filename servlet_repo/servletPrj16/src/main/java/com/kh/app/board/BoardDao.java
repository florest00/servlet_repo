package com.kh.app.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {

	public static int insert(SqlSession ss, BoardVo vo) {
		//SQL
		//반납
		return ss.insert("BoardMapper.write", vo);
	}

	public List<BoardVo> selectList(SqlSession ss) {
		return ss.selectList("BoardMapper.getBoardList");
	}

	public BoardVo selectBoardByNo(SqlSession ss, String no) {
		return ss.selectOne("BoardMapper.getBoardByNo", no);
	}

	public int edit(SqlSession ss, BoardVo vo) {
		return ss.update("BoardMapper.updateBoard", vo);
//		vo 전달하면서 BoardMapper.updateBoard 호출
	
	}

	public int delete(SqlSession ss, String no) {
		//SQL
		//반납
		return ss.delete("BoardMapper.deleteBoard", no);
	
	}

	public int increaseHit(SqlSession ss, String no) {
		return ss.update("BoardMapper.increaseHit", no);
	}
}
