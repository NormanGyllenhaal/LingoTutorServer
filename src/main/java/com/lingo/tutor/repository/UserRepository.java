package com.lingo.tutor.repository;

import com.lingo.tutor.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer>, CustomUserRepository {


    List<User> findAllByRole(Integer role);


    User findByFirebaseId(String firebaseId);

}
