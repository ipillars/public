package com.ipillars.sorter;

import java.util.Date;

/**
 * Created by Shriram Mani, Ironpillars, Inc on 04/09/2015.
 */
public class Person {

    public static final String STATIC_FINAL_STRING_VALUE = "Pura";
    public static String someStaticValue = "Vida";

    private String firstName;
    protected String lastName;
    private int age;
    private Date dob;
    private boolean human;

    public Person() {}

    public Person(String firstName, String lastName, int age, boolean human) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.human = human;
    }

    public Person(String firstName, String lastName, int age, Date dob, boolean human) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dob = dob;
        this.human = human;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", human=" + human +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }
}
