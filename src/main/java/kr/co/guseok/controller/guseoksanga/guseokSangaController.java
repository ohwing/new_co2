package kr.co.guseok.controller.guseoksanga;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.opensymphony.module.sitemesh.html.tokenizer.Parser;

import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.service.guseoksanga.guseokSangaService;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
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
		List<guseokSangaVO> sangaList = new ArrayList();
		sangaList = sangaService.selectListSangaDefaultStatus();
		model.addAttribute("sangaList", sangaList);
		
		return "board/list";
	}
	
	/**
	 * 상가 뷰
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(Model model, HttpServletRequest request, guseokSangaVO guseokSangaVo) {
		String page = request.getParameter("page");
		List<guseokSangaUploadVO> sangaImages = new ArrayList();
		guseokSangaVo = sangaService.selectViewSangaDefaultStatus(page);
		sangaImages = sangaService.selectSangaImage(guseokSangaVo);
		
		model.addAttribute("sangaView", guseokSangaVo);
		model.addAttribute("sangaImageView", sangaImages);
		
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
		String seq = request.getParameter("seq");
		
		if(seq != null) {
			guseokSangaVo = sangaService.selectViewSangaDefaultStatus(seq);
		}
		
		model.addAttribute("updataValues", guseokSangaVo);
		return "board/regist";
	}
	
	/**
	 * 
	 * @param uploadFile
	 * @param request
	 * @param model
	 * @param httpSession
	 * @param guseokSangaVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/registproc", method=RequestMethod.POST)
	public String registProc(@RequestParam("imgFiled") List<MultipartFile> uploadFile, MultipartHttpServletRequest request, Model model, HttpSession httpSession, guseokSangaVO guseokSangaVo) throws Exception {
		
		System.out.println("reAddProCtrl uploadFile : " + uploadFile.get(0));
		String uploadPath = "";
		
		guseokMemberVo = (guseokMemberVO) httpSession.getAttribute("login");
		guseokMemberVo.setStore_id(request.getParameter("store_id"));
		
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setStore_addr1(request.getParameter("store_addr1"));
		guseokSangaVo.setStore_addr2(request.getParameter("store_addr2"));
		guseokSangaVo.setStore_addr3(request.getParameter("store_addr3"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setEvent_comment(request.getParameter("event_comment"));
		
		guseokSangaVo.setEmail(guseokMemberVo.getEmail());
		
		System.out.println("===== "+ guseokSangaVo.getStore_id());
		System.out.println("===== "+ guseokSangaVo.getStore_addr1());
		System.out.println("===== "+ guseokSangaVo.getStore_addr2());
		System.out.println("===== "+ guseokSangaVo.getStore_addr3());
		
		sangaService.insertSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
		
		if(!uploadFile.get(0).isEmpty()) {
			uploadPath = sangaService.imgUpLoader(request, uploadFile, guseokMemberVo);
		} else {
			System.out.println("첨부파일 없음");
		}
		
		return "redirect: /board/list";
	}
	/**
	 * 
	 * @param uploadFile
	 * @param request
	 * @param model
	 * @param httpSession
	 * @param guseokSangaVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateproc", method=RequestMethod.POST)
	public String updateProc(@RequestParam("imgFiled") List<MultipartFile> uploadFile, MultipartHttpServletRequest request, Model model, HttpSession httpSession, guseokSangaVO guseokSangaVo) throws Exception {
		
		System.out.println("reAddProCtrl uploadFile : " + uploadFile.get(0));
		String uploadPath = "";		// 선언한 이유가 없음.
		Long seq = Long.parseLong(request.getParameter("page"));
		int file_id = Integer.parseInt(request.getParameter("file"));
		System.out.println("=== page : " + seq);
		
		guseokMemberVo = (guseokMemberVO) httpSession.getAttribute("login");
		guseokMemberVo.setStore_id(request.getParameter("store_id"));

		guseokSangaVo.setSeq(seq);
		guseokSangaVo.setFile_id(file_id);
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setStore_addr1(request.getParameter("store_addr1"));
		guseokSangaVo.setStore_addr2(request.getParameter("store_addr2"));
		guseokSangaVo.setStore_addr3(request.getParameter("store_addr3"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setEvent_comment(request.getParameter("event_comment"));
		
		guseokSangaVo.setEmail(guseokMemberVo.getEmail());
		
		System.out.println("===== "+ guseokSangaVo.getStore_id());
		System.out.println("===== "+ guseokSangaVo.getStore_addr1());
		System.out.println("===== "+ guseokSangaVo.getStore_addr2());
		System.out.println("===== "+ guseokSangaVo.getStore_addr3());
	
//		sangaService.insertSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
		sangaService.updateSangaDefaultStatus(guseokSangaVo, guseokMemberVo);
		
		if(!uploadFile.get(0).isEmpty()) {
			guseokSangaUploadVO guseokSangaUploadVo = new guseokSangaUploadVO();
			List<guseokSangaUploadVO> sangaImages = new ArrayList();
			
			sangaImages = sangaService.selectSangaImage(guseokSangaVo);
			guseokSangaUploadVo.setFile_id(file_id);
			
			//상가이미지 기존에 등록한 이미지 파일 삭제
			sangaService.deleteImageFile(sangaImages);
			//상가이미지 기존에 등록한 이미지 DB 삭제
			sangaService.deleteSangaImage(guseokSangaUploadVo);
			
			//상가이미지 수정시 이미지 다시 등록
			uploadPath = sangaService.imgUpLoader(request, uploadFile, guseokMemberVo);
		} else {
			System.out.println("첨부파일 없음");
		}
		
		return "redirect: /board/list";
	}
	
	/**
	 * 
	 * @param request
	 * @param model
	 * @param httpSession
	 * @param guseokSangaVo
	 * @param guseokSangaUploadVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/deleteproc", method=RequestMethod.GET)
	public String deleteProc(HttpServletRequest request, Model model, HttpSession httpSession, guseokSangaVO guseokSangaVo, guseokSangaUploadVO guseokSangaUploadVo) throws Exception {
		
		Long seq = Long.parseLong(request.getParameter("seq"));
		int file_id = Integer.parseInt(request.getParameter("file"));
		List<guseokSangaUploadVO> sangaImages = new ArrayList();
		
		guseokSangaVo.setSeq(seq);
		//상가 이미지 삭제를 위해 파일아이디 저장
		guseokSangaVo.setFile_id(file_id);
		guseokSangaUploadVo.setFile_id(file_id);
		sangaImages = sangaService.selectSangaImage(guseokSangaVo);
		
		sangaService.deleteImageFile(sangaImages);
		sangaService.deleteSangaImage(guseokSangaUploadVo);
		sangaService.deleteSangaDefaultStatus(guseokSangaVo);
		
		return "redirect: /board/list";
	}
	
}
