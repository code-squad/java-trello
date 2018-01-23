package codesquad.dto;

import javax.validation.constraints.Size;

import codesquad.domain.Member;

public class MemberDto {
	@Size(min = 3, max = 20)
	private String name;
	
	private String password;
	
	@Size(min = 6, max = 50)
	private String email;

	public MemberDto() {
	}

	public MemberDto(String email, String password) {
		this("none", password, email);
	}

	public MemberDto(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public Member toMember() {
		return new Member(name, password, email);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberDto [username=" + name + ", password=" + password + ", email=" + email + "]";
	}
	
}
