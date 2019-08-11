package kr.co.guseok.service.guseoksanga;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface guseokSangaService {
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public void updateSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public List<guseokSangaVO> selectListSangaDefaultStatus();
	
	public guseokSangaVO selectViewSangaDefaultStatus(String page);
	
	public String imgUpLoader(MultipartHttpServletRequest request, List<MultipartFile> uploadFile, guseokMemberVO guseokMemberVo) throws Exception;
	
	public List<guseokSangaUploadVO> selectSangaImage(guseokSangaVO guseokSangaVo);
	
	public void deleteSangaImage(guseokSangaUploadVO guseokSangaUploadVo);
	
	public void deleteSangaDefaultStatus(guseokSangaVO guseokSangaVo);
	
	public void deleteImageFile(List<guseokSangaUploadVO> sangaImages);
	
	
}
