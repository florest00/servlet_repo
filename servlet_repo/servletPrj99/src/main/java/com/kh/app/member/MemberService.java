package com.kh.app.member;

import java.sql.Connection;

import com.kh.app.db.JDBCTemplate;

public class MemberService {
	
	private final MemberDao dao = new MemberDao();

	public int join(MemberVo vo) throws Exception {
		// 비즈니스 로직
		// ==> JS 정규식 + JAVA => if문가지고 length~~~
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		// DAO 호출
		int result = dao.join(conn, vo);
		// 트랜잭션 처리
		if (result == 1) {
			conn.commit();
		} else {
			conn.rollback();
		}
		// 자원 반납
		conn.close();
		return result;
	}

	public MemberVo login(MemberVo vo) throws Exception {

		// 비즈니스 로직
		// 디비연결
		Connection conn = JDBCTemplate.getConn();
		// DAO 호출
		MemberVo loginMember = dao.login(conn, vo);
		// 트랜잭션 처리
		// 자원 반납
		conn.close();
		return loginMember;
	
	}

}
