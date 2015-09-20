## Synopsis

Simple java utility to sort a List/ArrayList of objects on its properties. Properties can be of any of the common types. Multiple properties can be chained to sort at a same time.

## Code Example

A working code sample is provided in the ListSorterTest.java file. The object to sort is in SampleObject.java.

Quick Code

        List sortOnKeys = new ArrayList<String>();
        sortOnKeys.add("firstName");
        sortOnKeys.add("age");
        // As many as there are simple properties (Long/Short/Double/Integer/Float/Byte/String/Date/Boolean) including primitives

        ListSorter listSorter = new ListSorter();
        List sortedList = (List<SampleObject>) listSorter.sortList(listToSort, sortOnKeys);

## Motivation

I couldn't find an easy way to sort a list of (unknown) objects on different properties, one after the other. So I ended up writing my own using Version 8 lambda functions.

## Installation

Samples are in the ListSorterTest.java file. A simple object is also provided to show how it sorts.

## API Reference

It uses reflection to find if the object contains a getter method. If there are no getters, it uses the field to get the data.

## Tests

Use ListSorterTest.java and SampleObject.java to test the code.

## Contributors

If you find any defects in this code, please create an issue in GIT and if you can provide some sample it would be helpful.

## License

Apache 2.0

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
