package kr.co.guseok.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterecptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
//	private static final Logger logger = LoggerFactory getLogger(LoginInterecptor.class);

	/**
	 * This implementation is empty.
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HttpSession httpSession = request.getSession();
		ModelMap modelmap = modelAndView.getModelMap();
		Object userVo = modelmap.get("login");
		
		if(userVo != null) {
			System.out.println("new login success");
			httpSession.setAttribute(LOGIN, userVo);
			response.sendRedirect("main");
		}
	}

	/**
	 * This implementation always returns <code>true</code>.
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession httpSession = request.getSession();
		
		if(httpSession.getAttribute(LOGIN) != null) {
			System.out.println("clear login data before");
			httpSession.removeAttribute(LOGIN);
		}
		
		return true;
	}

}
