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
import codesquad.domain.User;
import codesquad.domain.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@Test
	public void loginSuccess() {
		User user = new User("hue", "password", "hue@korea.kr");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));

		User loginUser = userService.login(user);
		assertThat(loginUser, is(user));
	}

	@Test(expected = UnAuthenticationException.class)
	public void loginOtherEmail() {
		User user = new User("hue", "password", "hue@korea.kr");
		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.empty());
		userService.login(user);
	}

	@Test(expected = UnAuthenticationException.class)
	public void loginOtherPassword() {
		User user = new User("hue", "password", "hue@korea.kr");
		User otheruser = new User("hue", "password22", "hue@korea.kr");

		when(userRepository.findByEmail(user.getEmail())).thenReturn(Optional.of(user));
		userService.login(otheruser);
	}

}
