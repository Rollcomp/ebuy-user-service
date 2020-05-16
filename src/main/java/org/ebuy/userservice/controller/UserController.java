package org.ebuy.userservice.controller;

import org.ebuy.userservice.dto.UserDto;
import org.ebuy.userservice.entity.User;
import org.ebuy.userservice.mapper.UserMapper;
import org.ebuy.userservice.model.UserRequest;
import org.ebuy.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Ozgur Ustun on May, 2020
 */

@RestController
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/get-users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userMapper.userListToUserDtoList(userList));
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok(userMapper.userToUserDto(user));
    }

    @GetMapping("/{userEmail}/get-user")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String userEmail) {
        User user = userService.findUserByEmail(userEmail);
        return ResponseEntity.ok(userMapper.userToUserDto(user));
    }

    @PostMapping("/update-user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userMapper.userToUserDto(userService.updateUser(userRequest)));
    }

    @PostMapping("/create-user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(userMapper.userToUserDto(userService.createUser(userRequest)));
    }

    @PostMapping("/delete-user")
    public ResponseEntity<String> deleteUser(@RequestBody UserRequest userRequest){
        userService.deleteUser(userRequest.getEmail());
        return ResponseEntity.ok("Completed");
    }

    @PostMapping("/delete-users")
    public ResponseEntity<String> deleteAllUsers(){
        userService.deleteAllUsers();
        return ResponseEntity.ok("Completed");
    }

}
