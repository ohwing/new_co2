package kr.co.guseok.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterecptor extends HandlerInterceptorAdapter{
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		    throws Exception {
			
			HttpSession httpSession = request.getSession();
			
			if(httpSession.getAttribute("login") == null) {
				System.out.println("로그인을 해주세요.");
				response.sendRedirect("/main/login");
				return false;
			}
		
			return true;
		}

}
