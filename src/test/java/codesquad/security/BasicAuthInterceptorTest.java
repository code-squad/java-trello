package codesquad.security;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;

import codesquad.domain.Member;
import codesquad.service.MemberService;

@RunWith(MockitoJUnitRunner.class)
public class BasicAuthInterceptorTest {
	@Mock
	private MemberService userService;

	@InjectMocks
	private BasicAuthInterceptor basicAuthInterceptor;

	@Test
	public void preHandle_로그인_성공() throws Exception {
		String email = "hue@korea.kr";
		String password = "password";
		MockHttpServletRequest request = basicAuthHttpRequest(email, password);
		Member loginUser = new Member("name", "password", email);
		when(userService.login(loginUser)).thenReturn(loginUser);

		basicAuthInterceptor.preHandle(request, null, null);
		assertThat(request.getSession().getAttribute(HttpSessionUtils.USER_SESSION_KEY), is(loginUser));
	}

	private MockHttpServletRequest basicAuthHttpRequest(String email, String password) {
		String encodedBasicAuth = Base64.getEncoder()
				.encodeToString(String.format("%s:%s", email, password).getBytes());
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("Authorization", "Basic " + encodedBasicAuth);
		return request;
	}
}
