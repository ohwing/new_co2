package kr.co.guseok.dao.guseokmain;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;

public interface guseokMainDAO {
	public guseokMemberVO guseokSangaMember(guseokMemberVO guseokMemberVo);
	public void insertSangaMember(guseokMemberVO guseokMemberVo);
}
