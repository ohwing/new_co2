package kr.co.guseok.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterecptor extends HandlerInterceptorAdapter{
	
	private final Logger logger = LoggerFactory.getLogger(AuthInterecptor.class);
	
	private void saveDestination(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		if(query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}
		
		if(request.getMethod().equals("GET")) {
			logger.info("destination: " + (uri+query));
			request.getSession().setAttribute("destination", uri+query);
		}
	}
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
			HttpSession httpSession = request.getSession();	
			
			if(httpSession.getAttribute("login") == null) {
				logger.debug("로그인을 해주세요.");
				saveDestination(request);
				response.sendRedirect("/main/login");
				return false;
			}
		
			return true;
		}

}
