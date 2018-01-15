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
	private Member member;
	@Column(nullable = false)
	private String boardName;
	
	public Board(String boardName, long memberId) {
		this.boardName = boardName;
	}
	public Board(String boardName, Member member) {
		this.boardName = boardName;
		this.member = member;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	
}
