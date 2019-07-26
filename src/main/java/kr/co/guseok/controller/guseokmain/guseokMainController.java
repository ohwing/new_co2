package kr.co.guseok.controller.guseokmain;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.vo.guseokmain.guseokMainVO;

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
	@RequestMapping(value = "/main")
	public String main(Model model, guseokMainVO guseokMainVo) {
		
		/**
		 * 최신 상가 정보
		 * 이달의 베스트 상가
		 * 공지사항 FAQ
		 */
		return "main/main";
	}
	
	/**
	 * 회원가입 페이지
	 * @param model
	 * @param guseokMainVO
	 * @return main/signup
	 */
	@RequestMapping(value = "/signup", method=RequestMethod.GET)
	public String signup(Model model, guseokMainVO guseokMainVo) {
		return "main/signup";
	}
	
	/**
	 * 회원가입 프로세스
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/signupproc", method=RequestMethod.POST)
	public String signupProc(Model model, HttpServletRequest request, guseokMainVO guseokMainVo) {
		
		guseokMainVo.setEmail(request.getParameter("email"));
		guseokMainVo.setPw(request.getParameter("pw"));
		mainService.insertSangaMember(guseokMainVo);
		
		return "redirect:/main/login";
	}
	
	/**
	 * 로그인 페이지
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public String login(Model model, guseokMainVO guseokMainVo) {
		
		return "main/login";
	}
	
	/**
	 * 로그인 프로세스
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/loginproc", method=RequestMethod.POST)
	public String loginProc(Model model, HttpServletRequest request, guseokMainVO guseokMainVo) {
		
		guseokMainVo.setEmail(request.getParameter("email"));
		guseokMainVo.setPw(request.getParameter("pw"));
		
		//이름변경 할 것 selectSangaMember
		guseokMainVO sanga_login = mainService.guseokSangaMember(guseokMainVo);
		
		if(sanga_login != null) {
			return "redirect:/main/main";
		} else {
			return "redirect:/main/login";
		}
		
	}
}
