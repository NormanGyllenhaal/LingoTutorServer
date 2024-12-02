package com.lingo.tutor.service;

import com.lingo.tutor.model.User;
import com.lingo.tutor.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers(Integer role) {
        return userRepository.findAllByRole(role);
    }


    public User getUser(Integer id) {
        return userRepository.findById(id).get();
    }

    public User getUserByFirebaseId(String firebaseId) {
        return userRepository.findByFirebaseId(firebaseId);
    }


    public User createUser(User user) {
        return userRepository.save(user);
    }


    public User updateUser(User user) {
        userRepository.updateUser(user);
        return userRepository.findById(user.getId()).get();
    }

}
