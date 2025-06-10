package com.kh.app.member;

import org.apache.ibatis.session.SqlSession;

import com.kh.app.mybatis.SqlSessionTemplate;

public class MemberService {

	private final MemberDao dao = new MemberDao();

	public int join(MemberVo vo) throws Exception {
		// biz
		// conn => ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		// DAO
		int result = dao.join(ss, vo);
		// tx
		if (result != 1) {
			ss.rollback();
		} else {
			ss.commit();
		}
		// close
		ss.close();
		return result;

	}

	public MemberVo login(MemberVo vo) throws Exception {
		
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		
		//rs => vo
		MemberVo selectedVo = dao.login(ss, vo);
		
		//close
		ss.close();
		
		return selectedVo;
		
	}

	public int quit(MemberVo vo) throws Exception {
		//biz
		//ss
		SqlSession ss = SqlSessionTemplate.getSqlSession();
		//dao
		int result = MemberDao.quit(ss, vo);
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
