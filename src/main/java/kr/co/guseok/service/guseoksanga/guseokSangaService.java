package kr.co.guseok.service.guseoksanga;

import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

public interface guseokSangaService {
	public void insertSangaDefaultStatus(guseokSangaVO guseokSangaVo, guseokMemberVO guseokMemberVo);
}
