package com.example.restful.restfulapiusingspringboot.version;

public class PersonV2 {
	private Name name;
	private Integer age;

	public PersonV2(Name name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
		this.age = age;
	}



	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "PersonV2 [name=" + name + "]";
	}
	
	
}
