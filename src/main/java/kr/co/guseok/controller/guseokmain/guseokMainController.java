package kr.co.guseok.controller.guseokmain;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thoughtworks.xstream.XStream;

import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.service.guseoksanga.guseokSangaService;
import kr.co.guseok.service.guseoktour.guseokTourService;
import kr.co.guseok.vo.guseokmain.guseokMainVO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;

@Controller
@RequestMapping("/main/*")
public class guseokMainController {
	@Autowired
	private guseokMainService mainService;
	
	@Autowired
	private guseokSangaService sangaService;
	
	@Autowired
	private guseokTourService tourService;
	
	
	
	private final Logger logger = LoggerFactory.getLogger(guseokMainController.class);


	/**
	 * 메인페이지
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */
	@RequestMapping(value = "/main", method=RequestMethod.GET)
	public String main(Model model, guseokMainVO guseokMainVo, guseokSangaVO guseokSangaVo, guseokTourRankVO guseokTourRankVO) {
		/**
		 * 최신 상가 정보
		 * 이달의 베스트 상가
		 * 공지사항 FAQ
		 */
		
		List<guseokTourRankVO> rankList = new ArrayList();
		List<guseokSangaVO> newestList = new ArrayList();
		
		rankList = tourService.selectTourRankList();
		newestList = sangaService.selectSangaNewestList();
		
//		for(guseokTourRankVO list : rankList) {
//			logger.debug(list.getTour_addr3());
//			logger.debug(list.getStore_id());
//			logger.debug("== " + list.getRank());
//			logger.debug(list.getReg_dt());
//		}

		
		model.addAttribute("rankList", rankList);
		model.addAttribute("newestList", newestList);
		
		return "main/main";
	}
	
	
	/**
	 * 상가 리스트 API
	 * @param model
	 * @param guseokMainVo
	 * @param guseokSangaVo
	 * @param guseokTourRankVO
	 * @return
	 */
	@RequestMapping(value = "/sangaapi", method=RequestMethod.GET)
	public String sangaApi(Model model, guseokMainVO guseokMainVo, guseokSangaVO guseokSangaVo, guseokTourRankVO guseokTourRankVO) {
		
		XStream xstream = new XStream();
		List<guseokSangaVO> sangalist = new ArrayList();
		
		sangalist = sangaService.getSanga();
		xstream.alias("Sanga", guseokSangaVO.class);
		
		String xml = xstream.toXML(sangalist);
		
		model.addAttribute("xml", xml);
		
		return "main/sangaapi";
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
	 * @throws Exception 
	 */
	@RequestMapping(value = "/signupproc", method=RequestMethod.POST)
	public String signupProc(Model model, HttpServletRequest request, HttpServletResponse response, guseokMemberVO guseokMemberVo) throws Exception {
		guseokMemberVo.setEmail(request.getParameter("email"));
		guseokMemberVo.setPw(request.getParameter("pw"));
		
		if(mainService.selectOneSangaMember(guseokMemberVo) != null) {
			return "redirect:/signuperror.jsp";
		} else {
			mainService.insertSangaMember(guseokMemberVo);
		}
		
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
		guseokMemberVO sanga_login = mainService.selectOneSangaMember(guseokMemberVo);

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
