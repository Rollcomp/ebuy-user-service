package org.ebuy.userservice.exception;

/**
 * Created by Ozgur Ustun on May, 2020
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
