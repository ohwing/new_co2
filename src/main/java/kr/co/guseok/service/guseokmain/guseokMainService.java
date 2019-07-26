package kr.co.guseok.service.guseokmain;

import kr.co.guseok.vo.guseokmain.guseokMainVO;

public interface guseokMainService {
	
	// 이름 변경할 것 selectSangaMember
	public guseokMainVO guseokSangaMember(guseokMainVO guseokMainVo);
	
	public void insertSangaMember(guseokMainVO guseokMainVo);
}
