package codesquad.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SecurityLoginCheckInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(SecurityLoginCheckInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle...........................");
		
		String dest = request.getParameter("dest");
		
		if(dest != null) {
			request.getSession().setAttribute("dest",  dest);
		}
		return super.preHandle(request,  response,  handler);
	}

}
