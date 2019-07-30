package kr.co.guseok.service.guseoksanga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.guseok.dao.guseoksanga.guseokSangaDAO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

@Service
public class guseokSangaServiceImpl implements guseokSangaService{

	@Autowired
	private guseokSangaDAO sangaDao;
	
	@Override
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo) {
		// TODO Auto-generated method stub
		sangaDao.insertSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
	}
	
}
