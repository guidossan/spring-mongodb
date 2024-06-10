package com.guilherme.springmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.guilherme.springmongodb.domain.Post;

import java.util.Date;
import java.util.List;



@Repository
public interface PostRepository extends MongoRepository<Post, String>{
    //o spring data ja monta a consulta
    List<Post> findByTitleContainingIgnoreCase(String text);
    //alternativa 
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String text);
    
    @Query("{ $and: [ { date: { $gte: ?1 } }, { field: { $lte: ?2 } }  , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } } , { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullsearch(String text, Date minDate, Date maxDate);
}
