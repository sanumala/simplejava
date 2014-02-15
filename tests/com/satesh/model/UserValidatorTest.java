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
