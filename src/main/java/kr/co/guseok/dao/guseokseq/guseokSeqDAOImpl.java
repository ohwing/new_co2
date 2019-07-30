package kr.co.guseok.dao.guseokseq;

import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.vo.guseokseq.guseokSeqVO;

@Repository
public class guseokSeqDAOImpl implements guseokSeqDAO {
	private static final String namespace = "kr.co.guseok.mapper.sangaSeqMapper";
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void updateSangaSeq(guseokSeqVO guseokSeqVo) {
		// TODO Auto-generated method stub
		
		guseokSeqVo = sqlSession.selectOne(namespace+".selectSeq", guseokSeqVo);
		if(guseokSeqVo != null) {
			int val = guseokSeqVo.getSeq_val()+1;
			guseokSeqVo.setSeq_val(val);
			sqlSession.update(namespace+".updateSeq", guseokSeqVo);
		} else {
			System.out.println("guseokSeqVo°¡ ¾øÀ½");
		}
		
	}
}
