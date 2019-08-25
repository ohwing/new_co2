package kr.co.guseok.controller.guseoksanga;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import kr.co.guseok.commons.paging.Criteria;
import kr.co.guseok.commons.paging.PageMaker;
import kr.co.guseok.controller.guseokmain.guseokMainController;
import kr.co.guseok.service.guseokmain.guseokMainService;
import kr.co.guseok.service.guseoksanga.guseokSangaService;
import kr.co.guseok.service.guseoktour.guseokTourService;
import kr.co.guseok.vo.guseokmember.guseokMemberVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaUploadVO;
import kr.co.guseok.vo.guseoksanga.guseokSangaVO;
import kr.co.guseok.vo.guseoksanga.guseokTourRankVO;

@Controller
@RequestMapping("/board/*")
public class guseokSangaController {
	
	@Autowired
	private guseokMainService mainService;
	
	@Autowired
	private guseokSangaService sangaService;
	
	@Autowired
	private guseokTourService tourService;
	
	private guseokMemberVO guseokMemberVo;
	
	private final Logger logger = LoggerFactory.getLogger(guseokMainController.class);
	
	
	/**
	 * csstest
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/csstest", method=RequestMethod.GET)
	public String csstest(Model model, guseokSangaVO guseokSangaVo) {
		Criteria criteria = new Criteria();
		criteria.setPage(1);
		criteria.setPerPageNum(10);
		
		List<guseokSangaVO> paging = sangaService.selectPagingList(criteria); 
		
		for(guseokSangaVO cdc : paging) {
			logger.debug(cdc.getSeq()+" : "+cdc.getStore_id());
		}
		
		return "board/csstest";
	}
	
	/**
	 * 상가 목록
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public String list(Model model, guseokSangaVO guseokSangaVo, Criteria criteria) {
		List<guseokSangaVO> sangaList = new ArrayList();
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(sangaService.selectListCount(criteria));
		
//		sangaList = sangaService.selectListSangaDefaultStatus();
		
		sangaList = sangaService.selectPagingList(criteria);
		model.addAttribute("sangaList", sangaList);
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";
	}
	
	/**
	 * 
	 * @param model
	 * @param request
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/searchlist", method=RequestMethod.GET)
	public String searchList(Model model, HttpServletRequest request, guseokSangaVO guseokSangaVo, Criteria criteria) {
		String gubun = request.getParameter("gubun");
		String searchTour = request.getParameter("list_tour_search");
		String searchStore = request.getParameter("list_store_search");
		List<guseokSangaVO> sangaList = new ArrayList();
		Map<String, Object> map = new HashMap<String, Object>();
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		
		
		if(gubun != null) {
			logger.debug(gubun);
			logger.debug(searchTour);
			logger.debug(searchStore);
			logger.debug("== "+criteria.getPageStart());
			logger.debug("== "+criteria.getPerPageNum());
			map.put("searchTour", searchTour);
			map.put("searchStore", searchStore);
			map.put("pageStart", criteria.getPageStart());
			map.put("perPageNum", criteria.getPerPageNum());
			
			pageMaker.setTotalCount(sangaService.selectSearchListCount(map));
			sangaList = sangaService.selectListSangaSearch(map);
			
//			logger.debug(sangaList.get(0).getTour_addr3());
//			logger.debug(sangaList.get(0).getStore_id());
			if(sangaList == null) {
				sangaList = sangaService.selectListSangaDefaultStatus();
			}
		}
		else {
			sangaList = sangaService.selectListSangaDefaultStatus();
			
		}
		
		model.addAttribute("sangaList", sangaList);
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}
	
	/**
	 * 상가 뷰
	 * @param model
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/view")
	public String view(Model model, HttpServletRequest request, guseokSangaVO guseokSangaVo, guseokTourRankVO guseokTourRankVo) {
		String page = request.getParameter("page");
		String store_id = null; 
		List<guseokSangaUploadVO> sangaImages = new ArrayList();
		List<guseokTourRankVO> tourCommentRank = new ArrayList();
		
		guseokSangaVo = sangaService.selectViewSangaDefaultStatus(page);
		store_id = guseokSangaVo.getStore_id();
		System.out.println(guseokSangaVo.getFile_id());
		if(guseokSangaVo.getFile_id() != 0) {
			sangaImages = sangaService.selectSangaImage(guseokSangaVo);
			model.addAttribute("sangaImageView", sangaImages);
		}
		
		tourCommentRank = tourService.selectTourCommentList(store_id);
		
		for(guseokTourRankVO cn : tourCommentRank) {
			logger.debug("== " + cn.getSeq());
			logger.debug(cn.getStore_id());
			logger.debug(cn.getRank_comment());
			logger.debug(cn.getReg_user_id());
			logger.debug(cn.getReg_dt());
			logger.debug("== " + cn.getRank());
		}
		
		model.addAttribute("sangaView", guseokSangaVo);
		model.addAttribute("tourCommentRank", tourCommentRank);
		
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
	 * 상가 등록 Proc
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
		
		logger.debug("reAddProCtrl uploadFile : " + uploadFile.get(0));
		String uploadPath = "";
		
		guseokMemberVo = (guseokMemberVO) httpSession.getAttribute("login");
		guseokMemberVo.setStore_id(request.getParameter("store_id"));
		
		guseokSangaVo.setApi_tourkey_id(request.getParameter("api_tourkey_id"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setTour_addr1(request.getParameter("tour_addr1"));
		guseokSangaVo.setTour_addr2(request.getParameter("tour_addr2"));
		guseokSangaVo.setTour_addr3(request.getParameter("tour_addr3"));
		guseokSangaVo.setStore_addr1(request.getParameter("store_addr1"));
		guseokSangaVo.setStore_addr2(request.getParameter("store_addr2"));
		guseokSangaVo.setStore_addr3(request.getParameter("store_addr3"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setEvent_comment(request.getParameter("event_comment"));
		
		guseokSangaVo.setEmail(guseokMemberVo.getEmail());
		
		System.out.println("===== "+ guseokSangaVo.getStore_id());
		System.out.println("===== "+ guseokSangaVo.getTour_addr1());
		System.out.println("===== "+ guseokSangaVo.getTour_addr2());
		System.out.println("===== "+ guseokSangaVo.getTour_addr3());
		
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
		guseokSangaVo.setApi_tourkey_id(request.getParameter("api_tourkey_id"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setTour_addr1(request.getParameter("tour_addr1"));
		guseokSangaVo.setTour_addr2(request.getParameter("tour_addr2"));
		guseokSangaVo.setTour_addr3(request.getParameter("tour_addr3"));
		guseokSangaVo.setStore_addr1(request.getParameter("store_addr1"));
		guseokSangaVo.setStore_addr2(request.getParameter("store_addr2"));
		guseokSangaVo.setStore_addr3(request.getParameter("store_addr3"));
		guseokSangaVo.setStore_id(request.getParameter("store_id"));
		guseokSangaVo.setEvent_comment(request.getParameter("event_comment"));
		
		guseokSangaVo.setEmail(guseokMemberVo.getEmail());
		
		System.out.println("===== "+ guseokSangaVo.getStore_id());
		System.out.println("===== "+ guseokSangaVo.getTour_addr1());
		System.out.println("===== "+ guseokSangaVo.getTour_addr2());
		System.out.println("===== "+ guseokSangaVo.getTour_addr3());
	
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
		String file_val = request.getParameter("file");
		String store_id = request.getParameter("store_id");
//		int file_id = Integer.parseInt(request.getParameter("file"));
		List<guseokSangaUploadVO> sangaImages = new ArrayList();
		
		guseokSangaVo.setSeq(seq);
		guseokSangaVo.setStore_id(store_id);
		//상가 이미지 삭제를 위해 파일아이디 저장
		if(file_val != null) {
			int file_id = Integer.parseInt(request.getParameter("file"));
			guseokSangaVo.setFile_id(file_id);
			guseokSangaUploadVo.setFile_id(file_id);
			sangaImages = sangaService.selectSangaImage(guseokSangaVo);
			
			sangaService.deleteImageFile(sangaImages);
			sangaService.deleteSangaImage(guseokSangaUploadVo);
		}
		
		
		sangaService.deleteSangaDefaultStatus(guseokSangaVo);
		sangaService.updateSangaMemberStore(guseokSangaVo);
		
		return "redirect: /board/list";
	}
	

	@RequestMapping(value = "/imagedeleteproc", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public int imageDeleteproc(HttpServletRequest request, Model model, HttpSession httpSession, guseokSangaVO guseokSangaVo, guseokSangaUploadVO guseokSangaUploadVo) throws Exception {
		
		Long seq = Long.parseLong(request.getParameter("seq"));
		String file_val = request.getParameter("file");
//		int file_id = Integer.parseInt(request.getParameter("file"));
		List<guseokSangaUploadVO> sangaImages = new ArrayList();
		
		guseokSangaVo.setSeq(seq);
		logger.debug("== "+seq);
		logger.debug("== "+file_val);
		//상가 이미지 삭제를 위해 파일아이디 저장
		if(file_val != null) {
			int file_id = Integer.parseInt(request.getParameter("file"));
			guseokSangaVo.setFile_id(file_id);
			guseokSangaUploadVo.setFile_id(file_id);
			sangaImages = sangaService.selectSangaImage(guseokSangaVo);
			
			sangaService.deleteImageFile(sangaImages);
			sangaService.deleteSangaImage(guseokSangaUploadVo);
			sangaService.updateSangaNullImage(guseokSangaVo);
			
			return 1;
		}
		
		return 0;
	}
	
	/**
	 * 지역코드 
	 * @param model
	 * @param request
	 * @param httpSession
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/locationlo")
	public String locationLo(Model model, HttpServletRequest request, HttpSession httpSession, guseokSangaVO guseokSangaVo) {
		String serviceKey = "JeWsKURTMSgkamRB3g3mTy3vENUQcsS2HNUBIWpWY1vbh83MpLL1e3gubQtp3%2B1SsAQT%2BPECJ%2FgrY91N9sd00w%3D%3D";
		String MobileOS = "ETC";
		String MobileApp="AppTest";
		String numOfRows="100";
		String test = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?"
					+ "ServiceKey=" + serviceKey
					+ "&MobileOS=" + MobileOS
					+ "&MobileApp="+ MobileApp
					+ "&numOfRows="+ numOfRows
					;
		Map<String, String> areaCode = new HashMap<String, String>();
		
		try {
			logger.debug(test);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(test);
			doc.getDocumentElement().normalize();
			
			logger.debug(doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("item");
			logger.debug("==== "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eELement = (Element) nNode;
	
	//				logger.debug("제목: "+eELement.getElementsByTagName("title").item(0).getNodeName());  // 태그명칭
					logger.debug("===============================================");
					logger.debug("지역코드: 		"	+	getTagValue("code", eELement));
					logger.debug("지역: 			"	+	getTagValue("name", eELement));
					areaCode.put(getTagValue("code", eELement), getTagValue("name", eELement));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			logger.debug("error : " + e);
		}
		
		model.addAttribute("areaCode", areaCode);
		return "board/locationlo";
	}
	
	/**
	 * 시/군/구 코드 
	 * @param model
	 * @param request
	 * @param httpSession
	 * @param guseokSangaVo
	 * @return
	 */
	@RequestMapping(value = "/locationgungu")
	public String locationGungu(Model model, HttpServletRequest request, HttpSession httpSession, guseokSangaVO guseokSangaVo) {
		String serviceKey = "JeWsKURTMSgkamRB3g3mTy3vENUQcsS2HNUBIWpWY1vbh83MpLL1e3gubQtp3%2B1SsAQT%2BPECJ%2FgrY91N9sd00w%3D%3D";
		String MobileOS = "ETC";
		String MobileApp="AppTest";
		String numOfRows="100";
		String areaCode=request.getParameter("areaCode");
		String test = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?"
					+ "ServiceKey=" + serviceKey
					+ "&MobileOS=" + MobileOS
					+ "&MobileApp="+ MobileApp
					+ "&numOfRows="+ numOfRows
					+ "&areaCode=" + areaCode
					;
		Map<String, String> gungu = new HashMap<String, String>();
		
		try {
			logger.debug(test);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(test);
			doc.getDocumentElement().normalize();
			
			logger.debug(doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("item");
			logger.debug("==== "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eELement = (Element) nNode;
	
	//				logger.debug("제목: "+eELement.getElementsByTagName("title").item(0).getNodeName());  // 태그명칭
					logger.debug("===============================================");
					logger.debug("지역코드: 		"	+	getTagValue("code", eELement));
					logger.debug("지역: 			"	+	getTagValue("name", eELement));
					gungu.put(getTagValue("code", eELement), getTagValue("name", eELement));
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
			logger.debug("error : " + e);
		}
		
		model.addAttribute("gungu", gungu);
		model.addAttribute("areacode", areaCode);
		
		return "board/locationgungu";
	}
	
	/**
	 * 지역기반 관광정보조회 메소드
	 * @param model
	 * @param request
	 * @param httpSession
	 * @param guseokSangaVo
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	@RequestMapping(value = "/location")
	public String location(Model model, HttpServletRequest request, HttpSession httpSession, guseokSangaVO guseokSangaVo) throws IOException, ParserConfigurationException, SAXException {
		String serviceKey = "JeWsKURTMSgkamRB3g3mTy3vENUQcsS2HNUBIWpWY1vbh83MpLL1e3gubQtp3%2B1SsAQT%2BPECJ%2FgrY91N9sd00w%3D%3D";
		String MobileOS = "ETC";
		String MobileApp="AppTest";
		String areaCode = request.getParameter("areaCode");
		String sigunguCode = request.getParameter("gungu");
		String numOfRows = "100";
		String contentTypeId = "12";
		StringBuilder sb = new StringBuilder();
		BufferedReader rd;
		String line;
		String test = "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaBasedList?"
					+ "ServiceKey=" + serviceKey
					+ "&MobileOS=" + MobileOS
					+ "&MobileApp="+ MobileApp
					+ "&areaCode="+ areaCode
					+ "&sigunguCode="+ sigunguCode
					+ "&numOfRows=" + numOfRows
					+ "&contentTypeId="+ contentTypeId
					;
		Map<String, String> location = new HashMap<String, String>();

		try {
			logger.debug(test);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(test);
			doc.getDocumentElement().normalize();
			
			logger.debug(doc.getDocumentElement().getNodeName());
			
			NodeList nList = doc.getElementsByTagName("item");
			logger.debug("==== "+nList.getLength());
			
			for(int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eELement = (Element) nNode;
	
	//				logger.debug("제목: "+eELement.getElementsByTagName("title").item(0).getNodeName());  // 태그명칭
					logger.debug("===============================================");
					logger.debug("제목: 		"	+	getTagValue("title", eELement));
					logger.debug("컨텐츠ID: 	"	+	getTagValue("contentid", eELement));
					logger.debug("썸네일: 	"	+	getTagValue("firstimage2", eELement));
					logger.debug("대표이미지: 	"	+	getTagValue("firstimage", eELement));
					logger.debug("X 좌표: 	"	+	getTagValue("mapx", eELement));
					logger.debug("Y 좌표: 	"	+	getTagValue("mapy", eELement));
					logger.debug("주소: 		"	+	getTagValue("addr1", eELement));
					logger.debug("상세주소: 	"	+	getTagValue("addr2", eELement));
					logger.debug("지역코드: 	"	+	getTagValue("areacode", eELement));
					logger.debug("시군구코드: 	"	+	getTagValue("sigungucode", eELement));
					logger.debug("우편번호: 	"	+	getTagValue("zipcode", eELement));
					logger.debug("컨텐츠타입: 	"	+	getTagValue("contenttypeid", eELement));
					location.put(getTagValue("contentid", eELement), getTagValue("title", eELement));
				}
			}
			
	//		rd.close();
	//        conn.disconnect();
	        logger.debug(test);
		}catch (Exception e) {
			logger.debug("error == "+e);
		}
		
		model.addAttribute("location", location);
		return "board/location";
	}
	
	/**
	 * 지역기반 관광정보 데이터 추출 함수
	 * @param tagName
	 * @param eELement
	 * @return
	 */
	private String getTagValue(String tagName, Element eELement) {
		// TODO Auto-generated method stub
		Node nNode = eELement.getElementsByTagName(tagName).item(0);
		String title = null;
	
		if(nNode != null) {
			title = eELement.getElementsByTagName(tagName).item(0).getTextContent();
		} else {
			title = "해당 값은 XML에 존재하지 않습니다.";
		}
		return title;
	}
	
	@RequestMapping(value = "/searchaddr")
	public String searchAddr(Model model, HttpServletRequest request, HttpSession httpSession, guseokSangaVO guseokSangaVo) {
		
		return "board/searchaddr";
	}
	
}
