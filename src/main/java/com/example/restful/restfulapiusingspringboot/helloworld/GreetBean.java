package com.example.restful.restfulapiusingspringboot.helloworld;

public class GreetBean {

	private String message;

	public GreetBean(String string) {
		this.message = string;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GreetBean [message=" + message + "]";
	}
	
}
