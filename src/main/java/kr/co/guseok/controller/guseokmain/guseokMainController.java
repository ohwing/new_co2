package kr.co.guseok.controller.guseokmain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.vo.guseokmain.guseokMainVO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;

@Controller
@RequestMapping("/main/*")
public class guseokMainController {
	@Autowired
	private guseokMainService mainService;

	/**
	 * 메인페이지
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public String main(Model model, guseokMainVO guseokMainVo) {
		
		/**
		 * 최신 상가 정보
		 * 이달의 베스트 상가
		 * 공지사항 FAQ
		 */
//		model.addAttribute("login", guseokMainVo);
		
		return "main/main";
	}
	
	/**
	 * 회원가입 페이지
	 * @param model
	 * @param guseokMainVO
	 * @return main/signup
	 */
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signup(Model model, guseokMemberVO guseokMemberVo) {
		return "main/signup";
	}
	
	/**
	 * 회원가입 프로세스
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/signupproc", method=RequestMethod.POST)
	public String signupProc(Model model, HttpServletRequest request, guseokMemberVO guseokMemberVo) {
		
		guseokMemberVo.setEmail(request.getParameter("email"));
		guseokMemberVo.setPw(request.getParameter("pw"));
		mainService.insertSangaMember(guseokMemberVo);
		
		return "redirect:/main/login";
	}
	
	/**
	 * 로그인 페이지
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(Model model, @ModelAttribute("guseokMemberVO")guseokMemberVO guseokMemberVo) {
		
		return "main/login";
	}
	
	/**
	 * 로그인 프로세스
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/loginproc", method=RequestMethod.POST)
	public void loginProc(Model model, guseokMemberVO guseokMemberVo, HttpServletRequest request, HttpSession httpSession) {
		
		guseokMemberVo.setEmail(request.getParameter("email"));
		guseokMemberVo.setPw(request.getParameter("pw"));
		
		//이름변경 할 것 selectSangaMember
		guseokMemberVO sanga_login = mainService.guseokSangaMember(guseokMemberVo);

		model.addAttribute("login", sanga_login);

	}
	
	/**
	 * 로그아웃 프로세스
	 * @param model
	 * @param guseokMemberVo
	 * @param request
	 * @param httpSession
	 */
	@RequestMapping(value = "/logoutproc", method=RequestMethod.GET)
	public String logOutProc(Model model, guseokMemberVO guseokMemberVo, HttpServletRequest request, HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/main/main";
	}
}
