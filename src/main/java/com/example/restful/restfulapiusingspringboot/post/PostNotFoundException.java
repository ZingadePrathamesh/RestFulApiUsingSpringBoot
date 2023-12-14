package com.example.restful.restfulapiusingspringboot.post;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
public class PostNotFoundException extends RuntimeException {

	public PostNotFoundException(String string) {
		super("Post not found: "+ string);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
