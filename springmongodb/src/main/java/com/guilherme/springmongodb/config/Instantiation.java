package com.guilherme.springmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guilherme.springmongodb.domain.User;
import com.guilherme.springmongodb.dto.AuthorDTO;
import com.guilherme.springmongodb.domain.Post;
import com.guilherme.springmongodb.repository.PostRepository;
import com.guilherme.springmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        //salva primeiro no BD para o BD criar um id próprio para o DTO buscar
        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        
        Post post1 = new Post(null, "Partiu viagem", sdf.parse("21/03/2034"), "Vou viajar para São Paulo. Abraços!", new AuthorDTO(alex));
        Post post2 = new Post(null, "Bom dia", sdf.parse("15/08/2018"), "Acordei feliz hoje!", new AuthorDTO(alex));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }

    
}
