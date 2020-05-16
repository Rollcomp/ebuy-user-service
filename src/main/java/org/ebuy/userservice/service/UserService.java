package org.ebuy.userservice.service;

import org.ebuy.userservice.entity.User;
import org.ebuy.userservice.exception.UserAlreadyExistException;
import org.ebuy.userservice.exception.UserNotFoundException;
import org.ebuy.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAllUsers();
    }

    public User findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findUserByEmail(String userEmail) {
        return userRepository.findUserByEmail(userEmail).orElseThrow(() -> new UserNotFoundException(userEmail));
    }

    public User updateUser(User updatedUser) {
        userRepository.findUserById(updatedUser.getId()).orElseThrow(() -> new UserNotFoundException(updatedUser.getEmail()));
        return userRepository.save(updatedUser);
    }

    public User createUser(User user) {
        userRepository.findUserByEmail(user.getEmail()).ifPresent(u -> new UserAlreadyExistException(user.getEmail()));
        return userRepository.save(user);
    }
}
