package codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;

@Entity
public class Board {
	@Id
	@GeneratedValue
	@Column(name = "BOARD_ID")
	private long id;
	@Column(nullable = false)
	private String name;
	@ManyToMany(mappedBy = "boardList")
	@OrderBy("id ASC")
	private List<User> users = new ArrayList<>();
	
	public Board() {
		this("default-board");
	}

	public Board(String name) {
		this.name = name;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + "]";
	}

}
