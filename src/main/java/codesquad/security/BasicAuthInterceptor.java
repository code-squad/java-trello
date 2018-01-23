package codesquad.security;

import java.nio.charset.Charset;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import codesquad.UnAuthenticationException;
import codesquad.domain.Member;
import codesquad.service.MemberService;

public class BasicAuthInterceptor extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(BasicAuthInterceptor.class);

	@Autowired
	private MemberService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authorization = request.getHeader("Authorization");
		log.debug("Authorization : {}", authorization);
		if (authorization == null || !authorization.startsWith("Basic")) {
			return true;
		}

		String base64Credentials = authorization.substring("Basic".length()).trim();
		String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
		final String[] values = credentials.split(":", 2);
		log.debug("email : {}", values[0]);
		log.debug("password : {}", values[1]);
		
		try {
			Member user = userService.login(new Member(values[0], values[1]));
			request.getSession().setAttribute(HttpSessionUtils.USER_SESSION_KEY, user);
			log.debug("Authorization Success");
			return true;
		} catch (UnAuthenticationException e) {
			return true;
		}
	}
}
