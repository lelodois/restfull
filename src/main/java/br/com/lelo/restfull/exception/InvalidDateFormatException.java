package br.com.lelo.restfull.exception;

public class InvalidDateFormatException extends RuntimeException {

	private static final long serialVersionUID = -2424907448700470069L;

	public InvalidDateFormatException(String message) {
		super(message);
	}

}
