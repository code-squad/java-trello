package codesquad.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import codesquad.dto.BoardDto;

@Entity
public class Board {
	@Id
	@GeneratedValue
	@Column(name = "BOARD_ID")
	private long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany(mappedBy = "boardList")
	private List<User> users = new ArrayList<>();
	
	public Board() {
	}

	public Board(String name, User user) {
		this.name = name;
//		users.add(user);
		user.addBoard(this);
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

	public void addUser(User user) {
		users.add(user);
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public BoardDto toBoardDto() {
		return new BoardDto(id, name);
	}

}
