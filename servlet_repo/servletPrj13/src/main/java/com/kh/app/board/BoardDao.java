package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDao {

	public int insert(Connection conn, BoardVo vo) throws Exception {
		//SQL
		String sql = "INSERT INTO BOARD(NO, TITLE, CONTENT) VALUES(SEQ_BOARD.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		int result = pstmt.executeUpdate();
		//close
		pstmt.close();
		
		return result;
		
	}

	public List<BoardVo> selectList(Connection conn) throws Exception {
		//SQL
		String sql = "SELECT NO,TITLE,CONTENT FROM BOARD ORDER BY NO DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<BoardVo> voList = new ArrayList<BoardVo>();
		while(rs.next()) {
			String no = rs.getString("NO");
			String title = rs.getString("TITLE");
			String content = rs.getString("CONTENT");

			BoardVo vo = new BoardVo(no, title, content);
			
			voList.add(vo);
		}
		
		//close
		rs.close();
		pstmt.close();
		
		return voList;
	}

}
