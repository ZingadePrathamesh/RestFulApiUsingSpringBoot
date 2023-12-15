package com.example.restful.restfulapiusingspringboot.post;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.restful.restfulapiusingspringboot.jpa.UsersJpaRepository;
import com.example.restful.restfulapiusingspringboot.users.Users;
import com.example.restful.restfulapiusingspringboot.users.UsersNotFoundException;

import jakarta.validation.Valid;

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
	
	@GetMapping(path = "/jpa/users/{user_id}/posts/{post_id}")
	public Post getPostById(@PathVariable Integer user_id, @PathVariable Integer post_id) {
		Optional<Users> user = usersJpaRepository.findById(user_id);
		
		if(user.isEmpty()) throw new UsersNotFoundException("id:" + user_id);
		
		List<Post> posts = user.get().getPosts();
		
		Predicate<? super Post> predicate= post -> post.getPostId().equals(post_id);
		Post post = posts.stream().filter(predicate).findFirst().orElse(null);
		if(post != null) return post;
		else
			throw new PostNotFoundException("id: " + post_id);
	}
	
	@PostMapping(path = "/jpa/users/{user_id}/posts")
	public ResponseEntity<Post> postPost(@PathVariable Integer user_id, @Valid @RequestBody Post post) {
		Optional<Users> user = usersJpaRepository.findById(user_id);
		
		if(user.isEmpty()) throw new UsersNotFoundException("id:" + user_id);
		
		post.setUser(user.get());
		postJPARepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(post.getPostId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
}
