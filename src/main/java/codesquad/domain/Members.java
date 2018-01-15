package codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Members {
	@Id
	@GeneratedValue
	@Column(name = "MEMBERS_ID")
	private long id;
	@ManyToMany(mappedBy = "membersList")
	private List<User> users = new ArrayList<>();

	public Members(User user) {
		users.add(user);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<User> getUsers() {
		return users;
	}
//
//	public void setUsers(List<User> member_users) {
//		this.users = users;
//	}

}
