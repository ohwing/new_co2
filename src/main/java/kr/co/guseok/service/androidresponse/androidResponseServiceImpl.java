package kr.co.guseok.service.androidresponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.guseok.dao.androidresponse.androidResponseDAO;
import kr.co.guseok.dao.guseoktour.guseokTourDAO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;
import kr.co.guseok.vo.guseoktourmember.guseokTourMemberVO;


@Service
public class androidResponseServiceImpl implements androidResponseService{

	@Autowired
	private androidResponseDAO androidResponseDAO;
	
	
	@Override
	public guseokTourMemberVO getTourMember(guseokTourMemberVO guseokTourMemberVO) {
		// TODO Auto-generated method stub
		return androidResponseDAO.getTourMember(guseokTourMemberVO);
	}
	
	@Override
	public guseokTourMemberVO checkTourMember(guseokTourMemberVO guseokTourMemberVO) {
		// TODO Auto-generated method stub
		return androidResponseDAO.checkTourMember(guseokTourMemberVO);
	}
	
	@Override
	public void insertTourMember(guseokTourMemberVO guseokTourMemberVO){
		androidResponseDAO.insertTourMember(guseokTourMemberVO);
	}
	
	@Override
	public List<guseokTourRankVO> getTourRankList(guseokTourRankVO guseokTourRankVO){
		return androidResponseDAO.getTourRankList(guseokTourRankVO);
	}
	
	@Override
	public List<guseokSangaVO> storeList(guseokSangaVO guseokSangaVO){
		return androidResponseDAO.storeList(guseokSangaVO);
	}
	
	@Override
	public void insertComment(guseokTourRankVO guseokTourRankVO){
		androidResponseDAO.insertComment(guseokTourRankVO);
	}
	
}
