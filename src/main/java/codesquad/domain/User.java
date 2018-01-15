package codesquad.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@Entity
@ToString
public class User {
    public static final GuestUser GUEST_USER = new GuestUser();
	
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	private long id;

	@Size(min = 3, max = 20)
	@Column(nullable = false, length = 20)
	private String name;

	@Size(min = 6, max = 20)
	@Column(nullable = false, length = 20)
	@JsonIgnore
	private String password;

	@Email
	@Size(min = 6, max = 50)
	@Column(unique = true, nullable = false, length = 50)
	private String email;
	
	@ManyToMany
	private List<Member> memberList;

	public User() {
	}
	
	public User(String email, String password) {
		this("", password, email);
	}

	public User(String name, String password, String email) {
		this(0L, name, password, email);
	}

	public User(long id, String name, String password, String email) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public boolean matchPassword(String password) {
		return password.equals(this.password);
	}

	public void addMember(Member member) {
		memberList.add(member);
	}
	
    @JsonIgnore
    public boolean isGuestUser() {
        return false;
    }

	private static class GuestUser extends User {
        @Override
        public boolean isGuestUser() {
            return true;
        }
    }
	
    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Member> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
