package kr.co.guseok.dao.guseokmain;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.vo.guseokmain.guseokMainVO;

@Repository
public class guseokMainDAOImpl implements guseokMainDAO{

	private static final String namespace = "kr.co.guseok.mapper.sangaMemberMapper";	 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public guseokMainVO guseokSangaMember(guseokMainVO guseokMainVo) {
		// TODO Auto-generated method stub
		
		return (guseokMainVO) sqlSession.selectOne(namespace+".getMember", guseokMainVo);
	}

	@Override
	public void insertSangaMember(guseokMainVO guseokMainVo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember", guseokMainVo);
	}

}
