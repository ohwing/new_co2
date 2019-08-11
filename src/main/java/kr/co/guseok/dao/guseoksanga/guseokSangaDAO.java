package kr.co.guseok.dao.guseoksanga;

import java.util.List;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface guseokSangaDAO {
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public void updateSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
	
	public List<guseokSangaVO> selectListSangaDefaultStatus();
	
	public guseokSangaVO selectViewSangaDefaultStatus(String page);
	
	public void insertSangaImagesUpload(guseokSangaUploadVO guseokSangaUploadVo);
	
	public List<guseokSangaUploadVO> selectSangaImage(guseokSangaVO guseokSangaVo);
	
	public void deleteSangaImage(guseokSangaUploadVO guseokSangaUploadVo);
	
	public void deleteSangaDefaultStatus(guseokSangaVO guseokSangaVo);
	
	
	
}
