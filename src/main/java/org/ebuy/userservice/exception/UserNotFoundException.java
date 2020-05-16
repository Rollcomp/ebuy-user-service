package org.ebuy.userservice.exception;

/**
 * Created by Ozgur Ustun on May, 2020
 */
public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException(Long userId) {
        super("User is not found with id: " + userId);
    }

    public UserNotFoundException(String userEmail) {
        super("User is not found with id: " + userEmail);
    }


}
