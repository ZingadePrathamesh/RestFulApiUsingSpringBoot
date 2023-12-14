package com.example.restful.restfulapiusingspringboot.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<Post, Integer> {
}
