package com.kh.app.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class BoardDao {


	public static int insert(SqlSession ss, BoardVo vo) throws Exception {
//		return ss.insert("abc.xml파일에 있는 hello", vo);
		return ss.insert("BoardMapper.write", vo);
	}
	
//	public static int insert(Connection conn, BoardVo vo) throws Exception {
//	String sql = """
//			INSERT INTO BOARD
//			(
//			    NO
//			    ,TITLE
//			    ,CONTENT
//			    ,WRITER_NO
//			)
//			VALUES
//			(
//			    SEQ_BOARD.NEXTVAL
//			    , ?
//			    , ?
//			    , 1
//			)
//			""";
//	PreparedStatement pstmt = conn.prepareStatement(sql);
//	pstmt.setString(1, vo.getTitle());
//	pstmt.setString(2, vo.getContent());
//	
//	int result = pstmt.executeUpdate();
//	
//	pstmt.close();
//	return result;
//}
	

	public List<BoardVo> selectList(SqlSession ss) throws Exception {
		//SQL
		//ss.selectList("쿼리문", 전달할데이터);
//		ss.selectList("BoardMapper.boardList", 전달할데이터);
		return ss.selectList("BoardMapper.getBoardList");
		//close
	
	}
//	public List<BoardVo> selectList(Connection conn) throws Exception {
//		String sql = """
//					SELECT *
//					FROM BOARD
//					WHERE DEL_YN = 'N'
//					ORDER BY NO DESC
//				""";
//		PreparedStatement pstmt = conn.prepareStatement(sql);
//		ResultSet rs = pstmt.executeQuery();
//		
//		List<BoardVo> voList = new ArrayList<BoardVo>();
//		
//		while(rs.next()) {
//			String no = rs.getString("NO");
//			String title = rs.getString("TITLE");
//			String content = rs.getString("CONTENT");
//			String writerNo = rs.getString("WRITER_NO");
//			String createdDate = rs.getString("CREATED_DATE");
//			String hit = rs.getString("HIT");
//			String delYn = rs.getString("DEL_YN");
//			
//			BoardVo vo = new BoardVo(no, title, content, writerNo, createdDate, hit, delYn);
//			
//			voList.add(vo);
//			
//		}
//		
//		rs.close();
//		pstmt.close();
//		return voList;
//		
//		
//	}

}
