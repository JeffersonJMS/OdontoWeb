package br.com.odontoWeb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 912612097687926974L;

	public NotFoundException() {
		super("Objeto não encontrado");
	}

	
}
