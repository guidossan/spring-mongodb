package com.guilherme.springmongodb.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.springmongodb.domain.User;
import com.guilherme.springmongodb.repository.UserRepository;
import com.guilherme.springmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
    //auto instancia o objeto
    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }
    
    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
