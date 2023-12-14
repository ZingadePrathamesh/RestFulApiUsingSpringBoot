package com.example.restful.restfulapiusingspringboot.post;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restful.restfulapiusingspringboot.jpa.UsersJpaRepository;
import com.example.restful.restfulapiusingspringboot.users.Users;
import com.example.restful.restfulapiusingspringboot.users.UsersNotFoundException;

@RestController
public class PostController {
	
	PostJPARepository postJPARepository;
	UsersJpaRepository usersJpaRepository;

	public PostController(PostJPARepository postJPARepository , UsersJpaRepository usersJpaRepository) {
		super();
		this.postJPARepository = postJPARepository;
		this.usersJpaRepository = usersJpaRepository;
	}
	
	

	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> getPostForAUser(@PathVariable Integer id){
		Optional<Users> user = usersJpaRepository.findById(id);
		
		if(user.isEmpty()) throw new UsersNotFoundException("id:" + id);
		
		return user.get().getPosts();
	}
	
}
