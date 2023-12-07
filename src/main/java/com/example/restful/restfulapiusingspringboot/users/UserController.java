package com.example.restful.restfulapiusingspringboot.users;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	public UserDaoService userDaoService;
	
	public UserController(UserDaoService userDaoService) {
		super();
		this.userDaoService = userDaoService;
	}

	// GET request to retrieve all users
    @GetMapping(path = "/users")
    public List<Users> getUsers() {
        // Delegate the task of finding all users to the UserDaoService
        return userDaoService.findAll();
    }

    // GET request to retrieve a specific user based on ID
    @GetMapping(path = "/users/{id}")
    public Users getUser(@PathVariable Integer id) {
        // Delegate the task of finding a user by ID to the UserDaoService
        return userDaoService.findOneById(id);
    }

    // POST request to create a new user
    @PostMapping(path = "/users")
    public ResponseEntity<Users> postUsers(@RequestBody Users user) {
        // Save the new user using the UserDaoService
        Users savedUser = userDaoService.save(user);

        // Build the URI of the newly created user
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        // Return a 201 Created response with the location of the new user
        return ResponseEntity.created(location).build();
    }
}
