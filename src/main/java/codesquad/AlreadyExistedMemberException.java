package codesquad;

public class AlreadyExistedMemberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlreadyExistedMemberException() {
		super();
	}

	public AlreadyExistedMemberException(String message) {
		super(message);
	}
}
