package codesquad.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import codesquad.UnAuthenticationException;
import codesquad.domain.Member;
import codesquad.domain.MemberRepository;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
	@Mock
	private MemberRepository userRepository;

	@InjectMocks
	private MemberService userService;

	@Test
	public void loginSuccess() {
		Member user = new Member("hue", "password", "hue@korea.kr");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

		Member loginUser = userService.login(user);
		assertThat(loginUser, is(user));
	}

	@Test(expected = UnAuthenticationException.class)
	public void loginOtherEmail() {
		Member user = new Member("hue", "password", "hue@korea.kr");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
		userService.login(user);
	}

	@Test(expected = UnAuthenticationException.class)
	public void loginOtherPassword() {
		Member user = new Member("hue", "password", "hue@korea.kr");
		Member otheruser = new Member("hue", "password22", "hue@korea.kr");

		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
		userService.login(otheruser);
	}

}
