package com.example.restful.restfulapiusingspringboot.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPerson {
	
	@GetMapping(path = "/person/v1/name")
	public PersonV1 getFirstVersionName() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/v2/name")
	public PersonV2 getSecondVersionName() {
		return new PersonV2(new Name("Bob", "Charlie"), 19);
	}
	
	@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getNameUsingParamVersion1() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person", params = "version=2")
	public PersonV2 getNameUsingParamVersion2() {
		return new PersonV2(new Name("Bob", "Charlie"), 19);
	}
	
	@GetMapping(path = "/person")
	public Object getNameUsingParam(@RequestParam Integer verson) {
		if(verson == 1) {
			return new PersonV1("Bob Charlie");			
		}
		else if(verson == 2) return new PersonV2(new Name("Bob", "Charlie"), 19);
		
		else return null;
	}
	
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getNameUsingHeaderFirst() {
		return new PersonV1("Bob Charlie");
	}
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getNameUsingHeaderSecond() {
		return new PersonV2(new Name("Bob", "Charlie"), 19);
	}
	
	
	@GetMapping(path = "/person/accept", produces = "application/version1+json")
	public PersonV1 getNameUsingContentNegotiation() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path = "/person/accept", produces = "application/version2+json")
	public PersonV2 getNameUsingContentNegotiation2() {
		return new PersonV2(new Name("Bob", "Charlie"), 19);
	}
	
	
	
}
