/*
Copyright 2015 Shriram Mani, Ironpillars, Inc.

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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shriram Mani, Ironpillars, Inc on 09/18/2015.
 */
public class ListSorterTest {

    public static void sortListofObjects(List<Person> listToSort) {

        SortKeys sortKeys = new SortKeys();
        sortKeys.addField("firstName")
                .addField("age", true);      // This (true) will sort the age descending because the second property is true

        // Other ways to specify a property to the sorter are
        //      .addField("lastName", String.class);
        //      .addField("lastName", String.class, true);

        // Instantiate a ListSorter
        ListSorter listSorter = new ListSorter();

        // Pas the data to sort (listToSort) and by the keys to sort (sortKeys)
        List sortedList = (List<Person>) listSorter.sortList(listToSort, sortKeys);

        System.out.println("Sorted List:\n" + sortedList);
    }

    public static void main(String[] args) {

        // This returns the sample list of objects of type Person
        List<Person> listToSort = buildData();

        // Multiple Key Sorting
        sortListofObjects(listToSort);
    }

    public static List buildData() {

        List<Person> personList = new ArrayList<Person>();

        personList = new ArrayList<Person>();

        personList.add(new Person("John1", "Chain", 25, true));
        personList.add(new Person("John1", "Beach", 36, true));
        personList.add(new Person("John2", "Balloon", 12, true));
        personList.add(new Person("John2", "Brake", 67, false));
        personList.add(new Person("Jane1", "Wheel", 24, true));
        personList.add(new Person("Jane1", "Carburator", 18, true));
        personList.add(new Person("Jane1", "Engine", 30, true));
        personList.add(new Person("Jane2", "Doe", 19, true));
        personList.add(new Person("Jane2", "Cycle", 42, false));

        return personList;
    }
}
