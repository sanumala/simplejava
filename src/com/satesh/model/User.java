/*
 * User.java
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
public class User {
    private String firstName;
    private String lastName;
    private int age;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private void printDetails() {
        System.out.println("First Name :" + this.getFirstName() + " Last Name :" + this.getLastName()
                + " Age: " + this.getAge());
    }

    public static void main(String[] args) {
        User user = new User("Satesh", "Anumala", 33);
        user.printDetails();
    }


}
