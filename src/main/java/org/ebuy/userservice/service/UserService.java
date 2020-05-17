package org.ebuy.userservice.service;

import org.ebuy.userservice.entity.User;
import org.ebuy.userservice.exception.UserAlreadyExistException;
import org.ebuy.userservice.exception.UserNotFoundException;
import org.ebuy.userservice.mapper.UserMapper;
import org.ebuy.userservice.model.UserRequest;
import org.ebuy.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findUserByEmail(String userEmail) {
        return userRepository.findUserByEmail(userEmail).orElseThrow(() -> new UserNotFoundException(userEmail));
    }

    public User updateUser(UserRequest userRequest) {
        User user = userRepository.findUserByEmail(userRequest.getEmail()).orElseThrow(() -> new UserNotFoundException(userRequest.getEmail()));
        user.setId(user.getId());
        return userRepository.save(userMapper.userToUser(user));
    }

    public User createUser(UserRequest userRequest) {
        Optional<User> user = userRepository.findUserByEmail(userRequest.getEmail());
        if (user.isPresent())
            throw new UserAlreadyExistException(user.get().getEmail());
        else
            return userRepository.save(user.get());
    }

    public void deleteUser(String email) {
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
        userRepository.delete(user);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }
}
