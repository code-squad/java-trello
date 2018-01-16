package codesquad.dto;

public class BoardDto {
	private long boardId;
	private String boardName;

	public BoardDto() {
	}

	public BoardDto(String boardName) {
		this.boardName = boardName;
	}

	public BoardDto(long boardId, String boardName) {
		this.boardName = boardName;
	}

	public long getBoardId() {
		return boardId;
	}

	public void setBoardId(long boardId) {
		this.boardId = boardId;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

}
