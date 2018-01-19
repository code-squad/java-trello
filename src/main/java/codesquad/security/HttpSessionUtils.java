package codesquad.security;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

import codesquad.domain.Member;

public class HttpSessionUtils {
    public static final String USER_SESSION_KEY = "loginedUser";

    public static boolean isLoginUser(NativeWebRequest webRequest) {
        Object loginedUser = webRequest.getAttribute(USER_SESSION_KEY, WebRequest.SCOPE_SESSION);
        return loginedUser != null;
    }

    public static Member getUserFromSession(NativeWebRequest webRequest) {
        if (!isLoginUser(webRequest)) {
            return Member.GUEST_MEMBER;
        }
        return (Member) webRequest.getAttribute(USER_SESSION_KEY, WebRequest.SCOPE_SESSION);
    }

    public static boolean isLoginUser(HttpSession session) {
        Object sessionedUser = session.getAttribute(USER_SESSION_KEY);
        if (sessionedUser == null) {
            return false;
        }
        return true;
    }

    public static Member getUserFromSession(HttpSession session) {
        if (!isLoginUser(session)) {
            return null;
        }

        return (Member) session.getAttribute(USER_SESSION_KEY);
    }
}
