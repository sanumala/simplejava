/*
 * UserValidatorTest.java
 * Created on : 2/15/14 7:46 PM
 * Author : satesh @ javaj2ee.com
 * License : Copyright 2014 Its OpenSource.
 *         : Please feel free to Share!
 *         : If you like it fork me @ http://github.com/sanumala
 */

package com.satesh.model;

import org.junit.Test;

/**
 * Created by satesh on 2/15/14.
 */
public class UserValidatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullUser() throws Exception {
        new UserValidator().validateUser(null);

    }
}
