package kr.co.guseok.controller.guseoksanga;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.guseok.vo.guseokmain.guseokSangaVO;

@Controller
@RequestMapping("/board/*")
public class guseokSangaController {
	
	/**
	 * 상가 목록
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, guseokSangaVO guseokSangaVo) {
		return null;
	}
	
	/**
	 * 상가 뷰
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(Model model, guseokSangaVO guseokSangaVo) {
		return null;
	}
	
	/**
	 * 상가 등록/수정 페이지
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/regist")
	public String regist(Model model, guseokSangaVO guseokSangaVo) {
		return null;
	}
	
	/**
	 * 상가 등록/수정
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/registproc")
	public String registProc(Model model, guseokSangaVO guseokSangaVo) {
		return null;
	}
	
	
	
	
	
}
