package kr.co.guseok.dao.guseoksanga;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.dao.guseokseq.guseokSeqDAO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseokseq.guseokSeqVO;

@Repository
public class guseokSangaDAOImpl implements guseokSangaDAO{

	private static final String namespace = "kr.co.guseok.mapper.sangaDefaultStatusMapper";	 
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private guseokSeqDAO seqDao;
	
	private guseokSeqVO guseokSeqVo = new guseokSeqVO();
	
	@Override
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		guseokSeqVo.setSeq_name("sanga_seq");
		seqDao.updateSangaSeq(guseokSeqVo);
		
		sqlSession.insert(namespace+".insertSanga", guseokSangaVo);
		sqlSession.insert(namespace+".updateMemberStore", guseokMemberVo);
	}

}
