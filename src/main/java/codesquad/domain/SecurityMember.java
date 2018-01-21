package codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class SecurityMember extends User{
	private static final String ROLE_PREFIX = "ROLE_";

	private Member member;
	
	public SecurityMember(Member member) {
		super(member.getEmail(), member.getPassword(), makeGrantedAuthority(member.getRoles()));
		this.member = member;
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<MemberRole> roles){
		List<GrantedAuthority> list = new ArrayList<>();
		roles.forEach(
			role -> list.add(
					new SimpleGrantedAuthority(ROLE_PREFIX + role.getRoleName())));
		return list;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
}
