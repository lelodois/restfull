package br.com.lelo.restfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundItemException extends RuntimeException {

    private static final long serialVersionUID = 5833750701672649244L;

    public NotFoundItemException() {
        super("item não encontrado");
    }

}
