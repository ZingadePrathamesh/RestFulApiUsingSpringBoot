package com.example.restful.restfulapiusingspringboot.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldAPI {
	
	private MessageSource messageSource;
	
	public HelloWorldAPI(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}

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
	
	@GetMapping(path = "/hello-world-i18n")
	public String greetI18N() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("good.morning.message", null, "default message", locale);	
	}
	
	@GetMapping(path = "/i18n")
	public String i18nPara() {
		Locale locale = LocaleContextHolder.getLocale();
		
		return messageSource.getMessage("i18n.message", null, "missing", locale);
	}
	
}
