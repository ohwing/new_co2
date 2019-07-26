package kr.co.guseok.dao.guseokmain;

import kr.co.guseok.vo.guseokmain.guseokMainVO;

public interface guseokMainDAO {
	public guseokMainVO guseokSangaMember(guseokMainVO guseokMainVo);
	public void insertSangaMember(guseokMainVO guseokMainVo);
}
