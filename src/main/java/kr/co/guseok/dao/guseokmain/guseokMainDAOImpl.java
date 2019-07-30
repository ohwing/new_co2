package kr.co.guseok.dao.guseokmain;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;

@Repository
public class guseokMainDAOImpl implements guseokMainDAO{

	private static final String namespace = "kr.co.guseok.mapper.sangaMemberMapper";	 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public guseokMemberVO guseokSangaMember(guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		
		return (guseokMemberVO) sqlSession.selectOne(namespace+".getMember", guseokMemberVo);
	}

	@Override
	public void insertSangaMember(guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember", guseokMemberVo);
	}

}
