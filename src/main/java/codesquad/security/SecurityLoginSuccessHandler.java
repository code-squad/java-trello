package codesquad.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class SecurityLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	private static final Logger log = LoggerFactory.getLogger(SecurityLoginSuccessHandler.class);

	@Override
	protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
		log.info("--------------determineTargetUrl--------------");

		Object dest = request.getSession().getAttribute("dest");
		String nextURL = null;

		if (dest != null) {
			request.getSession().removeAttribute("Dest");
			nextURL = (String) dest;
		} else {
			nextURL = super.determineTargetUrl(request, response);
		}

		log.info("--------------" + nextURL + "--------------");
		return nextURL;
	}
}
