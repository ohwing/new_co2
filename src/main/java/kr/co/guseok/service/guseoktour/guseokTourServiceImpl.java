package kr.co.guseok.service.guseoktour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.guseok.dao.guseoktour.guseokTourDAO;
import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;

@Service
public class guseokTourServiceImpl implements guseokTourService{

	@Autowired
	private guseokTourDAO tourDao;
	
	@Override
	public List<guseokTourRankVO> selectTourCommentList(String store_id) {
		// TODO Auto-generated method stub
		return tourDao.selectTourCommentList(store_id);
	}

	@Override
	public List<guseokTourRankVO> selectTourRankList() {
		// TODO Auto-generated method stub
		return tourDao.selectTourRankList();
	}
	
}
