package com.guilherme.springmongodb.resources;

import org.springframework.web.bind.annotation.RestController;

import com.guilherme.springmongodb.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/users")
public class userResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User user1 = new User("1", "Usuario 1", "usuario1@gmail.com");
        User user2 = new User("2", "Usuario 2", "usuario2@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1,user2));
        return ResponseEntity.ok().body(list);
    }

    
}
