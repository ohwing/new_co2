package kr.co.guseok.dao.guseoksanga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.guseok.commons.paging.Criteria;
import kr.co.guseok.dao.guseokseq.guseokSeqDAO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
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
	
	@Override
	public void updateSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace+".updateSanga", guseokSangaVo);
		sqlSession.update(namespace+".updateMemberStore", guseokMemberVo);
	}

	@Override
	public List<guseokSangaVO> selectListSangaDefaultStatus() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectListSanga");
	}
	
	@Override
	public List<guseokSangaVO> selectListSangaSearch(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList(namespace+".selectListSangaSearch", map);
	}

	@Override
	public guseokSangaVO selectViewSangaDefaultStatus(String page) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectViewSanga", page);
	}

	@Override
	public void insertSangaImagesUpload(guseokSangaUploadVO guseokSangaUploadVo) {
		// TODO Auto-generated method stub
		guseokSeqVo.setSeq_name("images_seq");
		seqDao.updateSangaSeq(guseokSeqVo);
		
		sqlSession.insert(namespace+".insertImageUpload", guseokSangaUploadVo);
		sqlSession.update(namespace+".updateSangaFileid", guseokSangaUploadVo);
		
	}

	@Override
	public List<guseokSangaUploadVO> selectSangaImage(guseokSangaVO guseokSangaVo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectSangaImage", guseokSangaVo);
	}

	@Override
	public void deleteSangaImage(guseokSangaUploadVO guseokSangaUploadVo) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".deleteSangaImage", guseokSangaUploadVo);
	}

	@Override
	public void deleteSangaDefaultStatus(guseokSangaVO guseokSangaVo) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace+".deleteSangaDefaultStatus", guseokSangaVo);
	}

	@Override
	public List<guseokSangaVO> selectSangaNewestList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectSangaNewestList");
	}

	@Override
	public List<guseokSangaVO> selectPagingList(Criteria criteria) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace+".selectPagingList", criteria);
	}

	@Override
	public int selectListCount(Criteria criteria) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectListCount", criteria);
	}

	@Override
	public int selectSearchListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectSearchListCount", map);
	}

}
