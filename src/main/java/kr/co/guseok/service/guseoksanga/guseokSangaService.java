package kr.co.guseok.service.guseoksanga;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.guseok.commons.paging.Criteria;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface guseokSangaService {
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public void updateSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public List<guseokSangaVO> getSanga();
	
	public List<guseokSangaVO> selectListSangaDefaultStatus();
	
	public List<guseokSangaVO> selectListSangaSearch(Map<String, Object> map);
	
	public guseokSangaVO selectViewSangaDefaultStatus(String page);
	
	public String imgUpLoader(MultipartHttpServletRequest request, List<MultipartFile> uploadFile, guseokMemberVO guseokMemberVo) throws Exception;
	
	public List<guseokSangaUploadVO> selectSangaImage(guseokSangaVO guseokSangaVo);
	
	public void updateSangaNullImage(guseokSangaVO guseokSangaVo);
	
	public void deleteSangaImage(guseokSangaUploadVO guseokSangaUploadVo);
	
	public void deleteSangaDefaultStatus(guseokSangaVO guseokSangaVo);
	
	public void updateSangaMemberStore(guseokSangaVO guseokSangaVo);
	
	public void deleteImageFile(List<guseokSangaUploadVO> sangaImages);
	
	public List<guseokSangaVO> selectSangaNewestList();
	
	public List<guseokSangaVO> selectPagingList(Criteria criteria);
	
	public int selectListCount(Criteria criteria);
	
	public int selectSearchListCount(Map<String, Object> map);
	
	
}
