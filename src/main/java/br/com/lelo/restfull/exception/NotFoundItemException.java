package br.com.lelo.restfull.exception;

public class NotFoundItemException extends RuntimeException {

    private static final long serialVersionUID = 5833750701672649244L;

    public NotFoundItemException(String message) {
		super(message);
	}

}
