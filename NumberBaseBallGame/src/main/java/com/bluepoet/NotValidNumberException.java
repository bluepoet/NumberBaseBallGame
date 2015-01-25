package main.java.com.bluepoet;

public class NotValidNumberException extends Exception {
	private static final long serialVersionUID = 1L;

	public NotValidNumberException() {
		super();
	}

	public NotValidNumberException(String msg) {
		super(msg);
	}

	public NotValidNumberException(Throwable e) {
		super(e);
	}

	public NotValidNumberException(String msg, Throwable e) {
		super(msg, e);
	}
}
