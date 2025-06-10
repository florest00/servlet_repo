package com.kh.app.member;

import org.apache.ibatis.session.SqlSession;

public class MemberDao {

	public int join(SqlSession ss, MemberVo vo) {
		//SQL
		//close
		return ss.insert("MemberMapper.join", vo);
	
	}

	public MemberVo login(SqlSession ss, MemberVo vo) {
		return ss.selectOne("MemberMapper.login", vo);
	
	}

	public static int quit(SqlSession ss, MemberVo vo) {
		//SQL
		//close
		return ss.update("MemberMapper.quit", vo);
		// ss.update => update queery 실행
	
	}



}
