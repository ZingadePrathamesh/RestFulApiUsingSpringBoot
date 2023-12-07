package com.example.restful.restfulapiusingspringboot.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	//dao service > static list of users
	
	public static List<Users> users = new ArrayList<Users>();
	
	static {
		users.add(new Users(1, "Nelson", LocalDate.now()));
		users.add(new Users(2, "Henry", LocalDate.now()));
		users.add(new Users(3, "Jackson", LocalDate.now()));		
	}
	
	public List<Users> findAll(){
		return users;
	}

	public Users findOneById(Integer id) {
		Predicate <? super Users > predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}
}
