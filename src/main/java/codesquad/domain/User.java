package codesquad.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
	@Id
	@GeneratedValue
	@Column(name="USER_ID")
	@Getter
	private long id;

	@Size(min = 3, max = 20)
	@Column(nullable = false, length = 20)
	@Getter
	@Setter
	private String name;

	@Size(min = 6, max = 20)
	@Column(nullable = false, length = 20)
	@JsonIgnore
	@Getter
	@Setter
	private String password;

	@Email
	@Size(min = 6, max = 50)
	@Column(unique = true, nullable = false, length = 50)
	@Getter
	@Setter
	private String email;
	
	@ManyToMany
	@Getter
	@Setter
	private List<Member> memberList;

	public User() {
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
