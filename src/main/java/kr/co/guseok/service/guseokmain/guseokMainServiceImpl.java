package kr.co.guseok.service.guseokmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.guseok.dao.guseokmain.guseokMainDAO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;

@Service
public class guseokMainServiceImpl implements guseokMainService{

	@Autowired
	private guseokMainDAO mainDao;
	
	@Override
	public guseokMemberVO selectOneSangaMember(guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		return mainDao.selectOneSangaMember(guseokMemberVo);
	}

	@Override
	public void insertSangaMember(guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		mainDao.insertSangaMember(guseokMemberVo);
	}

}
