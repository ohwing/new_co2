package kr.co.guseok.dao.guseoktour;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;

@Repository
public class guseokTourDAOImpl implements guseokTourDAO{

	private static final String namespace = "kr.co.guseok.mapper.sangaTourMapper";	 
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<guseokTourRankVO> selectTourCommentList(String store_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectTourComment", store_id);
	}

	@Override
	public List<guseokTourRankVO> selectTourRankList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectTourRank");
	}

}
