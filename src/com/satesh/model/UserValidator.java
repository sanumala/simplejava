
/*
 * UserValidator.java
 * Created on : 2/15/14 7:46 PM
 * Author : satesh @ javaj2ee.com
 * License : Copyright 2014 Its OpenSource.
 *         : Please feel free to Share!
 *         : If you like it fork me @ http://github.com/sanumala
 */

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