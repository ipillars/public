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
package com.ipillars.common;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by Shriram Mani, Ironpillars, Inc. on 9/17/2015.
 */
public class PojoTool {

    /**
     * Method to make a clone of an object. It doesn't care if it is serializable or clonable.
     * It goes through the columns (columns) in the object and use the getter method to get the value and use the setter method to set the values.
     * If it is accessible (public) then it will assign it directly
     *
     * @param objectToCopy - Object to make a (copy) clone of
     * @return - Clone of the object
     */
    public static Object deepCopy(Object objectToCopy) {

        Object retval = null;

        if (objectToCopy == null)
            return null;

        Class aClass = objectToCopy.getClass();

        // Lets see if there are any methods that is called clone. If so just call it and not worry
        try {
            Method method = aClass.getMethod("clone");

            if (method != null) {

                // If not set then IllegalAccessException is thrown
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }

                retval = method.invoke(objectToCopy);
            }
        } catch (NoSuchMethodException e) {
        } catch (InvocationTargetException e) {
        } catch (IllegalAccessException e) {
        }

        if (retval != null) {
            return retval;
        }

        // Ok method doesn't exist. First Create an instance of the class and Copy field by field

        // Get a new instance of the class
        try {
            retval = aClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        List<Field> fields = getAllFields(aClass);

        for (Field field : fields) {

            if (!Modifier.isFinal(field.getModifiers())) {

                // If not set then IllegalAccessException is thrown
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                try {
                    Object valueToAssign = field.get(objectToCopy);

                    Class dataType = field.getType();

                    // if Simple Object assign value directly
                    if ( isSimpleObject(dataType) ) {
                        field.set(retval, valueToAssign);
                    } else {
                        field.set(retval, deepCopy(valueToAssign));
                    }


                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return retval;
    }

    public static Object assignValues(String className, String[] tokens) throws ClassNotFoundException {
        Class aClass = Class.forName(className);
        return assignValues(aClass, tokens);
    }

    public static Object assignValues(Class aClass, String[] tokens) {

        Object retval = null;

        try {
            Field[] fields = aClass.getDeclaredFields();

            for (int i = 0; i < tokens.length; i++) {

                Field field = fields[i];

                // If not set then IllegalAccessException is thrown
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                String tokenString = tokens[i];
                Object valueToAssign = null;

                if (tokenString != null && !tokenString.equals("")) {

                    if (i < fields.length) {

                        Class dataType = field.getType();

                        if (dataType == String.class)
                            valueToAssign = tokenString;
                        else if (dataType == Boolean.class || dataType == Boolean.TYPE)
                            valueToAssign = Boolean.parseBoolean(tokenString);
                        else if (dataType == Byte.class || dataType == Byte.TYPE)
                            valueToAssign = Byte.parseByte(tokenString);
                        else if (dataType == Short.class || dataType == Short.TYPE)
                            valueToAssign = Short.parseShort(tokenString);
                        else if (dataType == Integer.class || dataType == Integer.TYPE)
                            valueToAssign = Integer.valueOf(tokenString);
                        else if (dataType == Long.class || dataType == Long.TYPE)
                            valueToAssign = Long.parseLong(tokenString);
                        else if (dataType == Float.class || dataType == Float.TYPE)
                            valueToAssign = Float.parseFloat(tokenString);
                        else if (dataType == Double.class || dataType == Double.TYPE)
                            valueToAssign = Double.parseDouble(tokenString);
                        else {
                            System.out.println("Warning: Do not know how to convert String to " + dataType);
                        }

                        if (retval == null) {
                            retval = aClass.newInstance();
                        }
                        field.set(retval, valueToAssign);

                    } else {
                        // throw an error that columns are exhausted. No more columns to assign the remaining token values.
                        break;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return retval;
    }

    /**
     * Get all the columns in the class including the super class. declaredFields returns only the locally declared columns.
     * This method recurse through the hierarchy of super classes and returns all the columns.
     * @param aClass - Class Object to start with
     * @return - Returns all the columns in the class
     */
    public static List<Field> getAllFields(Class aClass) {
        return getAllFields(aClass, new ArrayList<Field>());
    }

    /**
     * Get all the columns in the class including the super class. declaredFields returns only the locally declared columns.
     * This method recurse through the hierarchy of super classes and returns all the columns.
     * @param aClass - Class Object to start with
     * @param fields - Pass null to start from the beginning
     * @return - Returns all the columns in the class
     */
    public static List<Field> getAllFields(Class aClass, List<Field> fields) {

        Class superClass = aClass.getSuperclass();
        if(superClass != null){
            getAllFields(superClass, fields);
        }

        Field[] declaredFields = aClass.getDeclaredFields();

        for (int i=0; i<declaredFields.length; i++) {
            fields.add(declaredFields[i]);
        }
        return fields;
    }

    /**
     * Returns the Reflection Field Object. It first looks for the field locally. If not found, it will scan the entire hierarchy of super classes.
     * @param aClass - Class Object to start with
     * @param fieldName - Name of the field to scan
     * @return - Return the reflection field object
     */
    public static Field getFieldByName(Class aClass, String fieldName) {

        try {
            return aClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {

            Class superClass = aClass.getSuperclass();
            if(superClass != null){
                return getFieldByName(superClass, fieldName);
            }
        }
        return null;
    }

    /**
     * Checks if the class is a simple class
     * @param dataTypeClass - Record type
     * @return - Boolean true if it is simple else false
     */
    public static boolean isSimpleObject(Class dataTypeClass) {

        boolean retval = false;

        if (
                (dataTypeClass == String.class) ||
                        (dataTypeClass == Boolean.class || dataTypeClass == Boolean.TYPE) ||
                        (dataTypeClass == Byte.class || dataTypeClass == Byte.TYPE) ||
                        (dataTypeClass == Short.class || dataTypeClass == Short.TYPE) ||
                        (dataTypeClass == Integer.class || dataTypeClass == Integer.TYPE) ||
                        (dataTypeClass == Long.class || dataTypeClass == Long.TYPE) ||
                        (dataTypeClass == Float.class || dataTypeClass == Float.TYPE) ||
                        (dataTypeClass == Double.class || dataTypeClass == Double.TYPE) ||
                        (dataTypeClass == Date.class)
                ) {
            retval = true;
        }
        return retval;
    }
}
