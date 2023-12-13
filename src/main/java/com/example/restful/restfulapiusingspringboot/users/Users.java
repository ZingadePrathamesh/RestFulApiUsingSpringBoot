package com.example.restful.restfulapiusingspringboot.users;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class Users {

	private Integer id;

	@Size(min = 2, message = "Enter atleast 2 Characters in name.")
	@JsonProperty("user_name")
	private String name;
	@Past(message = "Date must be from the past")
	@JsonProperty("date_of_birth")
	private LocalDate birthDate;
	
	
	
	public Users(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
