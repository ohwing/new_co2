package kr.co.guseok.service.guseokmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.guseok.dao.guseokmain.guseokMainDAO;
import kr.co.guseok.vo.guseokmain.guseokMainVO;

@Service
public class guseokMainServiceImpl implements guseokMainService{

	@Autowired
	private guseokMainDAO mainDao;
	
	@Override
	public guseokMainVO guseokSangaMember(guseokMainVO guseokMainVo) {
		// TODO Auto-generated method stub
		return mainDao.guseokSangaMember(guseokMainVo);
	}

	@Override
	public void insertSangaMember(guseokMainVO guseokMainVo) {
		// TODO Auto-generated method stub
		mainDao.insertSangaMember(guseokMainVo);
	}

}
