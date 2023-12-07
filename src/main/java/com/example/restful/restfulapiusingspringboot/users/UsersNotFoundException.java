package com.example.restful.restfulapiusingspringboot.users;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) 
// This annotation indicates that the response status code for this exception should be 404 Not Found
public class UsersNotFoundException extends RuntimeException { 
		// This class extends the RuntimeException class, indicating that it is an unchecked exception

    	private static final long serialVersionUID = 1L; 
    	// This is a required field for Serializable classes, and it ensures compatibility across different versions of the class

    	public UsersNotFoundException(String message) { 
    	// This constructor takes a String message as input
        super("User not found: " + message); 
        // This calls the superclass constructor and passes a formatted message that includes the provided message
    }
}


