package com.example.restful.restfulapiusingspringboot.users;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	public UserDaoService userDaoService;
	
	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}

	@GetMapping(path = "/users")
	public List<Users> getUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping(path = "/users/id/{id}")
	public Users getUsers(@PathVariable Integer id){
		return userDaoService.findOneById(id);
	}
	
	
}
