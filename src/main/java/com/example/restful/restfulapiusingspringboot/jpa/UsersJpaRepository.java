package com.example.restful.restfulapiusingspringboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restful.restfulapiusingspringboot.users.Users;

public interface UsersJpaRepository extends JpaRepository<Users, Integer> {

}
