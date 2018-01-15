package codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MemberTest {
	private Member member;
	private User user;

	@Before
	public void setup() {
		user = new User("hue", "password", "hue@korea.kr");
		member = new Member(user);
	}

//	@Test
//	public void sameAdminCheck() {
//		assertTrue(member.isAdmin(user));
//	}
//
//	@Test
//	public void OtherAdminCheck() {
//		User otherUser = new User(2L, "hue", "password", "hue@korea.kr");
//		assertFalse(member.isAdmin(otherUser));
//	}

}
