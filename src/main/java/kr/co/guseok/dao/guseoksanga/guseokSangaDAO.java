package kr.co.guseok.dao.guseoksanga;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface guseokSangaDAO {
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
}
