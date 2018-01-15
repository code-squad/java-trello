package codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Member {
	@Id
	@GeneratedValue
	@Column(name="MEMBER_ID")
	@Getter
	private long id;
	@Getter
	@Setter
	@ManyToMany
	@JoinTable(name = "USER_MEMBER")
	private List<User> users;

	public Member(User user) {
		this.users = new ArrayList<>();
		users.add(user);
	}

}
