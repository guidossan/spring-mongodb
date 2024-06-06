package com.guilherme.springmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.springmongodb.domain.User;
import com.guilherme.springmongodb.repository.UserRepository;

@Service
public class UserService {
    //auto instancia o objeto
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
}
