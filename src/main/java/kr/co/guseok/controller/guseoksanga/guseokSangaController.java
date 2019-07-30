package kr.co.guseok.controller.guseoksanga;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.service.guseoksanga.guseokSangaService;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;

@Controller
@RequestMapping("/board/*")
public class guseokSangaController {
	
	@Autowired
	private guseokMainService mainService;
	
	@Autowired
	private guseokSangaService sangaService;
	
	private guseokMemberVO guseokMemberVo;
	
	/**
	 * 상가 목록
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/list")
	public String list(Model model, guseokSangaVO guseokSangaVo) {
		return "board/list";
	}
	
	/**
	 * 상가 뷰
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(Model model, guseokSangaVO guseokSangaVo) {
		return "board/view";
	}
	
	/**
	 * 상가 등록/수정 페이지
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/regist")
	public String regist(Model model, HttpServletRequest request, HttpSession httpSession, guseokSangaVO guseokSangaVo) {
		guseokMemberVo = (guseokMemberVO) httpSession.getAttribute("login");
		
		return "board/regist";
	}
	
	/**
	 * 상가 등록/수정
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/registproc", method=RequestMethod.POST)
	public String registProc(Model model, HttpServletRequest request, HttpSession httpSession, guseokSangaVO guseokSangaVo) {
		
		guseokMemberVo = (guseokMemberVO) httpSession.getAttribute("login");
		guseokMemberVo.setStore_id(request.getParameter("store_id"));
		
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setStore_addr1(request.getParameter("store_addr1"));
		guseokSangaVo.setStore_addr2(request.getParameter("store_addr2"));
		guseokSangaVo.setStore_addr3(request.getParameter("store_addr3"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setEvent_comment(request.getParameter("event_comment"));
		
		sangaService.insertSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
		
		return "redirect: /board/list";
	}
	
	
	
	
	
}
