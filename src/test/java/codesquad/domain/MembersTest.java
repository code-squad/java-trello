package codesquad.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MembersTest {
	private Members member;
	private User user;

	@Before
	public void setup() {
		user = new User("hue", "password", "hue@korea.kr");
		member = new Members(user);
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
