package kr.co.guseok.dao.androidresponse;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;
import kr.co.guseok.vo.guseoktourmember.guseokTourMemberVO;

@Repository
public class androidResponseDAOImpl implements androidResponseDAO{

	private static final String namespace = "kr.co.guseok.mapper.androidResponseMapper";	 
	@Autowired
	private SqlSession sqlSession;	
	
	@Override
	public guseokTourMemberVO getTourMember(guseokTourMemberVO guseokTourMemberVO) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace+".getTourMember", guseokTourMemberVO);
	}
	
	@Override
	public guseokTourMemberVO checkTourMember(guseokTourMemberVO guseokTourMemberVO) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne(namespace+".checkTourMember", guseokTourMemberVO);
	}
	
	@Override
	public guseokTourMemberVO insertTourMember(guseokTourMemberVO guseokTourMemberVO) {
		// TODO Auto-generated method stub
		
		guseokTourMemberVO.setSeq((Long)sqlSession.selectOne(namespace+".getTourMemberSeq", guseokTourMemberVO));		
		
		return sqlSession.selectOne(namespace+".insertMember", guseokTourMemberVO);
	}
	
	@Override
	public List<guseokTourRankVO> getTourRankList(guseokTourRankVO guseokTourRankVO) {
		// TODO Auto-generated method stub			
		
		return sqlSession.selectList(namespace+".getTourRankList", guseokTourRankVO);
	}
	
	@Override
	public List<guseokSangaVO> storeList(guseokSangaVO guseokSangaVO) {
		// TODO Auto-generated method stub			
		
		return sqlSession.selectList(namespace+".storeList", guseokSangaVO);
	}
	
	@Override
	public guseokTourMemberVO insertComment(guseokTourRankVO guseokTourRankVO) {
		// TODO Auto-generated method stub
		
		guseokTourRankVO.setSeq((Integer)sqlSession.selectOne(namespace+".getTourRankSeq", guseokTourRankVO));		
		
		return sqlSession.selectOne(namespace+".insertTourRank", guseokTourRankVO);
	}

}
