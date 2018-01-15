package codesquad.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Board {
	@Id
	@GeneratedValue
	@Column(name="BOARD_ID")
	@Getter
	private long id;
	@Getter
	@Setter
	@OneToOne
	private Member member;
	@Getter
	@Setter
	@Column(nullable = false)
	private String boardName;
	
	public Board(String boardName, long memberId) {
		this.boardName = boardName;
	}
	public Board(String boardName, Member member) {
		this.boardName = boardName;
		this.member = member;
	}

}
