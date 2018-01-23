package codesquad.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import codesquad.UnAuthorizedException;
import codesquad.domain.Member;

public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	private static final Logger log = LoggerFactory.getLogger(LoginUserHandlerMethodArgumentResolver.class);

	@Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    	log.debug("parameter : {}",parameter);
    	Member user = HttpSessionUtils.getUserFromSession(webRequest);
        if (!user.isGuestMember()) {
            return user;
        }

        LoginUser loginUser = parameter.getParameterAnnotation(LoginUser.class);
        if (loginUser.required()) {
            throw new UnAuthorizedException("You're required Login!");
        }
        return user;
    }
}
