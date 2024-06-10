package com.guilherme.springmongodb.resources;

import org.springframework.web.bind.annotation.RestController;


import com.guilherme.springmongodb.domain.Post;
import com.guilherme.springmongodb.resources.Util.URL;
import com.guilherme.springmongodb.services.PostService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(value = "/posts")
public class postResource {

    @Autowired
    private PostService service;

   

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){

        Post obj = service.findById(id);
        
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){


        text = URL.decodeParam(text);
        List<Post> list = service.findByTittle(text);
    
        
        return ResponseEntity.ok().body(list);
    }

}
