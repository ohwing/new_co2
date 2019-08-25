package kr.co.guseok.controller.androidresponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.guseok.service.androidresponse.androidResponseService;
import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.service.guseoksanga.guseokSangaService;
import kr.co.guseok.service.guseoktour.guseokTourService;
import kr.co.guseok.vo.guseokmain.guseokMainVO;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;
import kr.co.guseok.vo.guseoktourmember.guseokTourMemberVO;

@Controller
@RequestMapping("/android/*")
public class androidResponseController {
	@Autowired
	private guseokMainService mainService;
	
	@Autowired
	private guseokSangaService sangaService;
	
	@Autowired
	private guseokTourService tourService;
	
	@Autowired
	private androidResponseService androidResponseService;
	
	
	
	private final Logger logger = LoggerFactory.getLogger(androidResponseController.class);

	/**
	 * 메인페이지
	 * @param model
	 * @param guseokMainVO
	 * @return
	 */	
	
	@RequestMapping(value = "/getTourMember", method=RequestMethod.POST)
	@ResponseBody
	public guseokTourMemberVO storeLoginproc(HttpServletRequest request) {
		
		guseokTourMemberVO guseokTourMemberVO = new guseokTourMemberVO();

		guseokTourMemberVO.setEmail(request.getParameter("email"));
		guseokTourMemberVO.setPw(request.getParameter("pw"));
		
		guseokTourMemberVO tour_login = androidResponseService.getTourMember(guseokTourMemberVO);
		
		return tour_login;
	}
	
	@RequestMapping(value = "/signIn", method=RequestMethod.POST)
	@ResponseBody
	public boolean signIn(HttpServletRequest request) {
		
		guseokTourMemberVO guseokTourMemberVO = new guseokTourMemberVO();

		guseokTourMemberVO.setEmail(request.getParameter("email"));
		guseokTourMemberVO.setPw(request.getParameter("pw"));		
		
		if(androidResponseService.checkTourMember(guseokTourMemberVO) != null){
			return false;
		}
		else{
			androidResponseService.insertTourMember(guseokTourMemberVO);
		}
		
		return true;
	}
	
	@RequestMapping(value = "/storeList", method=RequestMethod.POST)
	@ResponseBody
	public List<guseokSangaVO> storeList(HttpServletRequest request) {
		

		guseokSangaVO guseokSangaVO = new guseokSangaVO();
		guseokSangaVO.setApi_tourkey_id(request.getParameter("contentId"));
		
		List<guseokSangaVO> sangaList = new ArrayList();
		sangaList = androidResponseService.storeList(guseokSangaVO);
		//Map<String, String> result = new HashMap<String, String>();		
		
		return sangaList;
	}
	
	@RequestMapping(value = "/getRank", method=RequestMethod.POST)
	@ResponseBody
	public List<guseokTourRankVO> storeRnakList(HttpServletRequest request) {
		
		guseokTourRankVO guseokTourRankVO = new guseokTourRankVO();
		
		guseokTourRankVO.setSanga_seq(request.getParameter("sangaSeq"));
		
		List<guseokTourRankVO> rankList = androidResponseService.getTourRankList(guseokTourRankVO);
		
		return rankList;
	}
	
	@RequestMapping(value = "/insertComment", method=RequestMethod.POST)
	@ResponseBody
	public boolean insertComment(HttpServletRequest request) {
		
		guseokTourRankVO guseokTourRankVO = new guseokTourRankVO();
		
		guseokTourRankVO.setStore_id(request.getParameter("rank"));
		guseokTourRankVO.setRank(Double.parseDouble(request.getParameter("rank")));
		guseokTourRankVO.setRank_comment(request.getParameter("rankComment"));
		guseokTourRankVO.setReg_user_id(request.getParameter("regUserId"));
		guseokTourRankVO.setSanga_seq(request.getParameter("sangaSeq"));
		
		androidResponseService.insertComment(guseokTourRankVO);
		
		return true;
	}
	
	
}
