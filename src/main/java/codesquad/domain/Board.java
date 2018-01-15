package codesquad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Board {
	@Id
	@GeneratedValue
	@Column(name="BOARD_ID")
	private long id;
	@OneToOne
	private Members members;
	@Column(nullable = false)
	private String boardName;
	
	public Board(String boardName, long membersId) {
		this.boardName = boardName;
	}
	public Board(String boardName, Members members) {
		this.boardName = boardName;
		this.members = members;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Members getMembers() {
		return members;
	}
	public void setMembers(Members members) {
		this.members = members;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
}
