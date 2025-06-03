package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDao {

	public int insert(Connection conn, BoardVo vo) throws Exception {
		//퀴리준비
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL , ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		//쿼리실행
		int result = pstmt.executeUpdate();
		//close
		pstmt.close();
		return result;
		
	}
	
	
}
