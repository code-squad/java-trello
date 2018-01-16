package codesquad;

public class AlreadyExistedUserException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AlreadyExistedUserException() {
		super();
	}

	public AlreadyExistedUserException(String message) {
		super(message);
	}
}
