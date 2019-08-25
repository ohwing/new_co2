package kr.co.guseok.dao.guseoktour;

import java.util.List;

import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;

public interface guseokTourDAO {
	public List<guseokTourRankVO> selectTourCommentList(String store_id);
	
	public List<guseokTourRankVO> selectTourRankList();

}
