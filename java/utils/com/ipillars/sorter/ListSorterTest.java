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
import java.util.Date;
import java.util.List;

/**
 * Created by Shriram Mani, Ironpillars, Inc on 09/18/2015.
 */
public class ListSorterTest {

    public static void main(String[] args) {

        // Multiple Key Sorting
        sortMultipleKeys();
    }

    public static void sortMultipleKeys() {

        // This returns the list of objects of type Sample Object.
        List<SampleObject> listToSort = buildData();

        List sortOnKeys = new ArrayList<String>();
        sortOnKeys.add("firstName");
        sortOnKeys.add("age");
        // Add as many as there are in the object
        //sortOnKeys.add("lastName");

        ListSorter listSorter = new ListSorter();
        List sortedList = (List<SampleObject>) listSorter.sortList(listToSort, sortOnKeys);

        System.out.println("Sorted List:\n" + sortedList);
    }

    public static List buildData() {

        List<SampleObject> sampleList = new ArrayList<SampleObject>();

        sampleList = new ArrayList<SampleObject>();

        sampleList.add(new SampleObject("John1", "Chain", 25, true));
        sampleList.add(new SampleObject("John1", "Beach", 36, true));
        sampleList.add(new SampleObject("John2", "Balloon", 12, true));
        sampleList.add(new SampleObject("John2", "Brake", 67, false));
        sampleList.add(new SampleObject("Jane1", "Wheel", 24, true));
        sampleList.add(new SampleObject("Jane1", "Carburator", 18, true));
        sampleList.add(new SampleObject("Jane1", "Engine", 30, true));
        sampleList.add(new SampleObject("Jane2", "Doe", 19, true));
        sampleList.add(new SampleObject("Jane2", "Cycle", 42, false));

        return sampleList;
    }
}
