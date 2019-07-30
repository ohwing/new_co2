package kr.co.guseok.service.guseokmain;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;

public interface guseokMainService {
	
	// 이름 변경할 것 selectSangaMember
	public guseokMemberVO guseokSangaMember(guseokMemberVO guseokMemberVo);
	
	public void insertSangaMember(guseokMemberVO guseokMemberVo);
}
