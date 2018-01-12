package codesquad.dto;

import javax.validation.constraints.Size;

import codesquad.domain.User;

public class UserDto {
	@Size(min = 3, max = 20)
	private String name;
	@Size(min = 6, max = 20)
	private String password;
	@Size(min = 6, max = 50)
	private String email;

	public UserDto() {
	}

	public UserDto(String email, String password) {
		this("none", password, email);
	}

	public UserDto(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public User toUser() {
		return new User(name, password, email);
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

}
