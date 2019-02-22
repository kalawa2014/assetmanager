package com.sfeir.graph.assetmanager.reference.controller;

import com.sfeir.graph.assetmanager.reference.repository.UserRepository;
import com.sfeir.graph.assetmanager.reference.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/users")
public class UserController {



    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public List<AppUser> getAllUser() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}
