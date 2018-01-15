package codesquad.dto;

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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
