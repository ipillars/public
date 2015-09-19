/*
Copyright [2015] [Shriram Mani, Ironpillars, Inc.]

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.ipillars.sorter;

/**
 * Created by Shriram Mani, Ironpillars, Inc on 04/09/2015.
 */
public class SampleObject {

    public static final String STATIC_FINAL_STRING_VALUE = "Pura";
    public static String someStaticValue = "Vida";

    private String firstName;
    protected String lastName;
    private int age;
    private boolean human;

    public SampleObject() {}

    public SampleObject(String firstName, String lastName, int age, boolean human) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.human = human;
    }

    @Override
    public String toString() {
        return "SampleObject{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", human=" + human +
                ", someStaticValue=" + someStaticValue +
                ", STATIC_FINAL_STRING_VALUE=" + STATIC_FINAL_STRING_VALUE +
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

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean human) {
        this.human = human;
    }
}
