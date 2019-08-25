package kr.co.guseok.service.androidresponse;

import java.util.List;

import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;
import kr.co.guseok.vo.guseoktourmember.guseokTourMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface androidResponseService {
	
	public guseokTourMemberVO getTourMember(guseokTourMemberVO guseokTourMemberVO);
	
	public guseokTourMemberVO checkTourMember(guseokTourMemberVO guseokTourMemberVO);
	
	public void insertTourMember(guseokTourMemberVO guseokTourMemberVO);
	
	public List<guseokTourRankVO> getTourRankList(guseokTourRankVO guseokTourRankVO);
	
	public List<guseokSangaVO> storeList(guseokSangaVO guseokSangaVO);
	
	public void insertComment(guseokTourRankVO guseokTourRankVO);
}
