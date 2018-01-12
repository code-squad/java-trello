package codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {
	@Test
	public void matchPasswordSuccess() {
		User user = new User("hue", "password", "hue@korea.kr");
		assertTrue(user.matchPassword(user.getPassword()));
	}

	@Test
	public void matchPasswordFail() {
		User user = new User("hue", "password", "hue@korea.kr");
		assertFalse(user.matchPassword(user.getPassword() + 22));
	}
}
