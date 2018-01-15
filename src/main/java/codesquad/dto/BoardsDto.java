package codesquad.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardsDto {
	private long userId;
	private long boardId;
	private String boardName;

	public BoardsDto() {
	}
	
	public BoardsDto(long userId, String boardName) {
		this.userId = userId;
		this.boardName = boardName;
	}
	
	public BoardsDto(long userId, long boardId, String boardName) {
		this.userId = userId;
		this.boardId = boardId;
		this.boardName = boardName;
	}

}
