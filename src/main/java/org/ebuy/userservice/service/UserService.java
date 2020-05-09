package org.ebuy.userservice.service;

import org.ebuy.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ozgur Ustun on May, 2020
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

}
