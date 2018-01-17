package codesquad.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
	
	@OneToMany
	private List<Deck> decks = new ArrayList<>();

	public Board() {
		this("default-board");
	}

	public Board(String name) {
		this(0L, name);
	}

	public Board(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void addDeck(Deck deck) {
		decks.add(deck);
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
	
	public List<Deck> getDecks(){
		return decks;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Board other = (Board) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Board [id=" + id + ", name=" + name + "]";
	}

}
