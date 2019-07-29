package kr.co.guseok.dao.guseoksanga;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

@Repository
public class guseokSangaDAOImpl implements guseokSangaDAO{

	private static final String namespace = "kr.co.guseok.mapper.sangaDefaultStatusMapper";	 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertSanga", guseokSangaVo);
		sqlSession.insert(namespace+".insertMemberStore", guseokSangaVo);
	}

}
