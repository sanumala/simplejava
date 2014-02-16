/*
 * UserTest.java
 * Created on : 2/15/14 7:46 PM
 * Author : satesh @ javaj2ee.com
 * License : Copyright 2014 Its OpenSource.
 *         : Please feel free to Share!
 *         : If you like it fork me @ http://github.com/sanumala
 */

package com.satesh.model;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by satesh on 2/15/14.
 */
public class UserTest {

    public static final String EXPECTED_FIRST_NAME = "Satesh";
    public static final String EXPECTED_LAST_NAME = "Anumala";
    public static final int EXPECTED_AGE = 33;
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("Satesh", "Anumala", 33);
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test Completed");

    }

    @Test
    public void testUserDetails() throws Exception {
        Assert.assertEquals(EXPECTED_FIRST_NAME, user.getFirstName());
        Assert.assertEquals(EXPECTED_LAST_NAME, user.getLastName());
        Assert.assertEquals(EXPECTED_AGE, user.getAge());

    }
}
