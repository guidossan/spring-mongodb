package com.guilherme.springmongodb.services;

import java.util.Date;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.springmongodb.domain.Post;

import com.guilherme.springmongodb.repository.PostRepository;
import com.guilherme.springmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
    //auto instancia o objeto
    @Autowired
    private PostRepository repo;
    
    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
  
    public List<Post> findByTittle(String text){
        //return repo.findByTitleContainingIgnoreCase(text);
        return repo.findByTitle(text);
    }
    public List<Post> fullsearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24*60*60+1000);
        return repo.fullsearch(text, minDate, maxDate);
    }
}
