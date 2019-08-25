package kr.co.guseok.service.guseoksanga;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.guseok.commons.paging.Criteria;
import kr.co.guseok.dao.guseoksanga.guseokSangaDAO;
import kr.co.guseok.dao.guseokseq.guseokSeqDAO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseokseq.guseokSeqVO;

@Service
public class guseokSangaServiceImpl implements guseokSangaService{

	@Autowired
	private guseokSangaDAO sangaDao;
	
	@Autowired
	private guseokSeqDAO seqDao;
	
	//로컬 경로
	String savePath = "D:\\upload\\images";
	
	//운영경로
//	String savePath = "/ohwig1/tomcat/webapps/fileupload";
	
    int sizeLimit = 3 * 1024 * 1024;
	
	@Override
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		sangaDao.insertSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
	}
	
	@Override
	public void updateSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		sangaDao.updateSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
	}

	@Override
	public List<guseokSangaVO> selectListSangaDefaultStatus() {
		return sangaDao.selectListSangaDefaultStatus();
		
	}
	
	@Override
	public List<guseokSangaVO> selectListSangaSearch(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sangaDao.selectListSangaSearch(map);
	}

	@Override
	public guseokSangaVO selectViewSangaDefaultStatus(String page) {
		// TODO Auto-generated method stub
		return sangaDao.selectViewSangaDefaultStatus(page);
	}
	
	public String imgUpLoader(MultipartHttpServletRequest request, List<MultipartFile> uploadFile, guseokMemberVO guseokMemberVo) throws Exception {
		
//		savePath = request.getServletPath();
		
		OutputStream out = null;
        PrintWriter printWriter = null;
        guseokSangaUploadVO guseokSangaUploadVo = new guseokSangaUploadVO();
        
        //FILD_ID 값 증가
        guseokSeqVO guseokSeqVo = new guseokSeqVO();
        guseokSeqVo.setSeq_name("sangaImgFile_seq");
        seqDao.updateSangaSeq(guseokSeqVo);
        
		 try {
			 for(MultipartFile ulFile : uploadFile) {
				String fileName = ulFile.getOriginalFilename();
				String originalFileExtension = fileName.substring(fileName.lastIndexOf("."));
				String uuid = UUID.randomUUID().toString().replaceAll("-", "");
				byte[] bytes = ulFile.getBytes();
		        
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hhmmss");
				Calendar c = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
		        
		        String storedFileName = guseokMemberVo.getStore_id()+ "_" + sdf.format(c.getTime()) + uuid + originalFileExtension;
		        File file = new File(savePath, storedFileName);
		        
		        out = new FileOutputStream(file);
		        out.write(bytes);
		        
//		        guseokSangaUploadVo.setFile_id(guseokMemberVo.getStore_id());
		        guseokSangaUploadVo.setAtchmnfl_mask_nm(storedFileName);
		        guseokSangaUploadVo.setAtchmnfl_nm(fileName);
		        
		        sangaDao.insertSangaImagesUpload(guseokSangaUploadVo);
			 }
			
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	    	try {
                if (out != null) {
                    out.close();
                }
                if (printWriter != null) {
                    printWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
	    }
		return null;
	}

	@Override
	public List<guseokSangaUploadVO> selectSangaImage(guseokSangaVO guseokSangaVo) {
		// TODO Auto-generated method stub
		return sangaDao.selectSangaImage(guseokSangaVo);
	}

	/**
	 * 상가 이미지 디비 삭제
	 */
	@Override
	public void deleteSangaImage(guseokSangaUploadVO guseokSangaUploadVo) {
		// TODO Auto-generated method stub
		sangaDao.deleteSangaImage(guseokSangaUploadVo);
	}

	/**
	 * 상가 정보 디비 삭제
	 */
	@Override
	public void deleteSangaDefaultStatus(guseokSangaVO guseokSangaVo) {
		// TODO Auto-generated method stub
		sangaDao.deleteSangaDefaultStatus(guseokSangaVo);
	}

	/**
	 * 상가 이미지 파일 삭제
	 */
	@Override
	public void deleteImageFile(List<guseokSangaUploadVO> sangaImages) {
		// TODO Auto-generated method stub
		for(guseokSangaUploadVO images : sangaImages) {
			File file = new File(savePath+"\\"+images.getAtchmnfl_mask_nm());
			if(file.exists() == true) {
				file.delete();
			}
		}
	}

	@Override
	public List<guseokSangaVO> selectSangaNewestList() {
		// TODO Auto-generated method stub
		return sangaDao.selectSangaNewestList();
	}

	@Override
	public List<guseokSangaVO> selectPagingList(Criteria criteria) {
		// TODO Auto-generated method stub
		return sangaDao.selectPagingList(criteria);
	}

	@Override
	public int selectListCount(Criteria criteria) {
		// TODO Auto-generated method stub
		return sangaDao.selectListCount(criteria);
	}

	@Override
	public int selectSearchListCount(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sangaDao.selectSearchListCount(map);
	}

	
	
}
