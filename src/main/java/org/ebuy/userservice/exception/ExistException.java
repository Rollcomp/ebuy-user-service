package org.ebuy.userservice.exception;

/**
 * Created by Ozgur Ustun on May, 2020
 */
public class ExistException extends RuntimeException {
    public ExistException(String message) {
        super(message);
    }
}
