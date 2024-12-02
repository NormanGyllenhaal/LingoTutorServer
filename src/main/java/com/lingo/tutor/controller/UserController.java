package com.lingo.tutor.controller;

import com.lingo.tutor.model.User;
import com.lingo.tutor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(@RequestParam Integer role) {
        return userService.getAllUsers(role);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }


    @GetMapping("/firebase/{firebaseId}")
        public User getUserByFirebaseId(@PathVariable String firebaseId) {
        return userService.getUserByFirebaseId(firebaseId);
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }


    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }


}
