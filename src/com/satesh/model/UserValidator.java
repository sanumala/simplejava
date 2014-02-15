package com.satesh.model;

/**
 * Created by satesh on 2/15/14.
 */
public class UserValidator {

    public void validateUser(User user) throws IllegalArgumentException {

        if (user == null) {
            throw new IllegalArgumentException();
        }
    }
}
