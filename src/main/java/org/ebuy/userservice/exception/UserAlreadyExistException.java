package org.ebuy.userservice.exception;

/**
 * Created by Ozgur Ustun on May, 2020
 */
public class UserAlreadyExistException extends ExistException {

    public UserAlreadyExistException(String message) {
        super("User is already exist with this email: " + message);
    }
}
