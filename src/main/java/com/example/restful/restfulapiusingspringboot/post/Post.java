package com.example.restful.restfulapiusingspringboot.post;

import com.example.restful.restfulapiusingspringboot.users.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer postId;
	@Size(min = 5, message = "Description should be atleast 5 characters long.")
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Users user;
	
	public Post(Integer postId, String description) {
		super();
		this.postId = postId;
		this.description = description;
	}
	public Post() {
		super();
	}
	
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", description=" + description + "]";
	}
}
