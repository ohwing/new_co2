package kr.co.guseok.service.guseokmain;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;

public interface guseokMainService {
	
	// �̸� ������ �� selectSangaMember
	public guseokMemberVO selectOneSangaMember(guseokMemberVO guseokMemberVo);
	
	public void insertSangaMember(guseokMemberVO guseokMemberVo);
}
