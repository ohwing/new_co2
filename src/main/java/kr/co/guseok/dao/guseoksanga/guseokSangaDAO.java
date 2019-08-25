package kr.co.guseok.dao.guseoksanga;

import java.util.List;
import java.util.Map;

import kr.co.guseok.commons.paging.Criteria;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface guseokSangaDAO {
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public void updateSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public List<guseokSangaVO> getSanga();
	
	public List<guseokSangaVO> selectListSangaDefaultStatus();
	
	public List<guseokSangaVO> selectListSangaSearch(Map<String, Object> map);
	
	public guseokSangaVO selectViewSangaDefaultStatus(String page);
	
	public void insertSangaImagesUpload(guseokSangaUploadVO guseokSangaUploadVo);
	
	public void updateSangaNullImage(guseokSangaVO guseokSangaVo);
	
	public List<guseokSangaUploadVO> selectSangaImage(guseokSangaVO guseokSangaVo);
	
	public void deleteSangaImage(guseokSangaUploadVO guseokSangaUploadVo);
	
	public void deleteSangaDefaultStatus(guseokSangaVO guseokSangaVo);
	
	public void updateSangaMemberStore(guseokSangaVO guseokSangaVo);
	
	public List<guseokSangaVO> selectSangaNewestList();
	
	public List<guseokSangaVO> selectPagingList(Criteria criteria);
	
	public int selectListCount(Criteria criteria);
	
	public int selectSearchListCount(Map<String, Object> map);
	
//	public List<guseokSangaVO> listCriteria(Criteria criteria) throws Exception;
	
	
}
