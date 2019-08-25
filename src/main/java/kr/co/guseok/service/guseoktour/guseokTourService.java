package kr.co.guseok.service.guseoktour;

import java.util.List;

import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;

public interface guseokTourService {
	public List<guseokTourRankVO> selectTourCommentList(String store_id);
	
	public List<guseokTourRankVO> selectTourRankList();
}
