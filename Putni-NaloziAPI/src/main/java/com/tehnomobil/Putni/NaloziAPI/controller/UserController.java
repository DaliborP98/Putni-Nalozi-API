package com.tehnomobil.Putni.NaloziAPI.controller;

import com.tehnomobil.Putni.NaloziAPI.moduls.User;
import com.tehnomobil.Putni.NaloziAPI.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @RequestMapping("/user")
    public List<User> getAllUsers() {

        return myUserDetailsService.getAllUsers();
    }

    @RequestMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        return myUserDetailsService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public UserDetails login(@RequestBody User user) throws Exception {
        UserDetails provjeraUser= myUserDetailsService.loadUserByUsername(user.getEMail());
        if (provjeraUser.getPassword().equals(user.getLozinka())){
            return  provjeraUser;
        }
        else throw new Exception("Email i lozinka se ne poklapaju");

    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    public void addUser(@RequestBody User user) {

        myUserDetailsService.addUser(user);
    }

    @RequestMapping("/posaljiLozinku/{email}")
    public void posaljiLozinku(@PathVariable String email) throws Exception {
        myUserDetailsService.posaljiLozinku(email);
    }
}
