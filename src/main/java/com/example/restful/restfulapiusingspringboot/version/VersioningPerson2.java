package com.example.restful.restfulapiusingspringboot.version;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPerson2 {

	//versioning using URI
	@GetMapping(path = "/person2/v1")
	public PersonV1 getNameUsingURIVersion1() {
		return new PersonV1("Sanmay Godbole");
	}
	
	//versioning using URI
	@GetMapping(path = "/person2/v2")
	public PersonV2 getNameUsingURIVersion2() {
		return new PersonV2(new Name("Sanmay" ,"Godbole"), 21);
	}
	
	//versioning using Params
	@GetMapping(path = "/person2" , params = "version=1")
	public PersonV1 getNameUsingParamVersion1() {
		return new PersonV1("Sanmay Godbole");
	}
	
	//Versioning using Params
	@GetMapping(path = "/person2" , params = "version=2")
	public PersonV2 getNameUsingParamVersion2() {
		return new PersonV2(new Name("Sanmay" ,"Godbole"), 21);
	}
	
	//versioning using Header
	@GetMapping(path = "/person2/header" , headers  = "X-API-VERSION=1")
	public PersonV1 getNameUsingHeaderVersion1() {
		return new PersonV1("Sanmay Godbole");
	}
	//versioning using Header
	@GetMapping(path = "/person2/header" , headers  = "X-API-VERSION=2")
	public PersonV2 getNameUsingHeaderVersion2() {
		return new PersonV2(new Name("Sanmay" ,"Godbole"), 21);
	}
	
	//versioning using Content Negotiation
	@GetMapping(path = "/person2/accept" , produces  = "application/version1+json")
	public PersonV1 getNameUsingContentNegotiationVersion1() {
		return new PersonV1("Sanmay Godbole");
	}
	//versioning using Content Negotiation
	@GetMapping(path = "/person2/accept" , produces  = "application/version2+json")
	public PersonV2 getNameUsingContentNegotiationVersion2() {
		return new PersonV2(new Name("Sanmay" ,"Godbole"), 21);
	}
	
}
