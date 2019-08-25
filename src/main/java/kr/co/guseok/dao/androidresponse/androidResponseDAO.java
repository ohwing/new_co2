package kr.co.guseok.dao.androidresponse;

import java.util.List;

import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;
import kr.co.guseok.vo.guseoktourmember.guseokTourMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface androidResponseDAO {	
	
	public guseokTourMemberVO getTourMember(guseokTourMemberVO guseokTourMemberVO);
	
	public guseokTourMemberVO checkTourMember(guseokTourMemberVO guseokTourMemberVO);

	public guseokTourMemberVO insertTourMember(guseokTourMemberVO guseokTourMemberVO);

	public List<guseokTourRankVO> getTourRankList(guseokTourRankVO guseokTourRankVO);
	
	public List<guseokSangaVO> storeList(guseokSangaVO guseokSangaVO);
	
	public guseokTourMemberVO insertComment(guseokTourRankVO guseokTourRankVO);

}
