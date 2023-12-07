package com.example.restful.restfulapiusingspringboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;

@RestController
public class HelloWorldAPI {

	@GetMapping(path = "/hello-world")
	public String greet() {
		return new String("Hello Prathamesh! Time to bring a Change!");		
	}
	
	@GetMapping(path = "/hello-world-bean")
	public GreetBean greetBean() {
		return new GreetBean("Hello Prathamesh! Time to bring a Change!");		
	}
	
	@GetMapping(path = "/hello-world-bean/{name}")
	public GreetBean greetBean2(@PathVariable String name) {
		return new GreetBean("Hello Prathamesh! Time to bring" + name + "!");		
	}
}
