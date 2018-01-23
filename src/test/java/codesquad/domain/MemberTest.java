package codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberTest {
	private Member user;
	
	@Before
	public void setup() {
		user = new Member("hue", "password", "hue@korea.kr");
	}
	
	@Test
	public void matchPasswordSuccess() {
		assertTrue(user.matchPassword(user.getPassword()));
	}

	@Test
	public void matchPasswordFail() {
		assertFalse(user.matchPassword(user.getPassword() + 22));
	}
	
}
