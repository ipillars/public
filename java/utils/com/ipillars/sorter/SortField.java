package com.ipillars.sorter;

/**
 * Created by shriram on 9/19/2015.
 */
public class SortField {
    String fieldName;
    Boolean descending = false;
    Class fieldClass;

    public SortField() {
    }

    public SortField(String fieldName) {
        this.fieldName = fieldName;
    }

    public SortField(String fieldName, Class fieldClass) {
        this.fieldName = fieldName;
        this.fieldClass = fieldClass;
    }

    public SortField(String fieldName, Boolean descending) {
        this.fieldName = fieldName;
        this.descending = descending;
    }

    public SortField(String fieldName, Boolean descending, Class fieldClass) {
        this.fieldName = fieldName;
        this.fieldClass = fieldClass;
        this.descending = descending;
    }

    public SortField(String fieldName, Class fieldClass, Boolean descending) {
        this.fieldName = fieldName;
        this.fieldClass = fieldClass;
        this.descending = descending;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Boolean getDescending() {
        return descending;
    }

    public void setDescending(Boolean descending) {
        this.descending = descending;
    }

    public Class getFieldClass() {
        return fieldClass;
    }

    public void setFieldClass(Class fieldClass) {
        this.fieldClass = fieldClass;
    }

    @Override
    public String toString() {
        return "SortField{" +
                "fieldName='" + fieldName + '\'' +
                ", descending=" + descending +
                ", fieldClass=" + fieldClass +
                '}';
    }
}