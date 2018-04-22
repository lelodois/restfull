package br.com.lelo.restfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDateFormatException extends RuntimeException {

    private static final long serialVersionUID = -2424907448700470069L;

    public InvalidDateFormatException(String message) {
        super(message);
    }

}
