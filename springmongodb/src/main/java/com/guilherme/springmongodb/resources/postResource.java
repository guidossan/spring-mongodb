package com.guilherme.springmongodb.resources;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guilherme.springmongodb.domain.Post;
import com.guilherme.springmongodb.domain.User;
import com.guilherme.springmongodb.dto.UserDto;
import com.guilherme.springmongodb.services.PostService;
import com.guilherme.springmongodb.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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

}
