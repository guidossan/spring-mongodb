package com.guilherme.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guilherme.springmongodb.domain.Post;
import java.util.List;



@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    //o spring data ja monta a consulta
    List<Post> findByTitleContainingIgnoreCase(String text);
}
