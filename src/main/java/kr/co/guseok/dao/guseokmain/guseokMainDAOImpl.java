package kr.co.guseok.dao.guseokmain;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.dao.guseokseq.guseokSeqDAO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseokseq.guseokSeqVO;

@Repository
public class guseokMainDAOImpl implements guseokMainDAO{

	private static final String namespace = "kr.co.guseok.mapper.sangaMemberMapper";	 
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private guseokSeqDAO seqDao;
	
	private guseokSeqVO guseokSeqVo = new guseokSeqVO();
	
	@Override
	public guseokMemberVO selectOneSangaMember(guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		
		return (guseokMemberVO) sqlSession.selectOne(namespace+".getMember", guseokMemberVo);
	}

	@Override
	public void insertSangaMember(guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		guseokSeqVo.setSeq_name("sangaMem_seq");
		seqDao.updateSangaSeq(guseokSeqVo);
		
		sqlSession.insert(namespace+".insertMember", guseokMemberVo);
	}

}
