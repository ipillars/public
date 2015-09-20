package com.ipillars.sorter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shriram on 9/19/2015.
 */
public class SortKeys {

    private List<SortField> sortFields = new ArrayList<SortField>();

    public SortKeys() {}

    public SortKeys(String fieldName) {
        addField(fieldName);
    }

    public SortKeys(String fieldName, Class fieldClass) {
        addField(fieldName, fieldClass);
    }

    public SortKeys(String fieldName, Boolean descending) {
        addField(fieldName, descending);
    }

    public SortKeys(String fieldName, Class fieldClass, Boolean descending) {
        addField(fieldName, fieldClass, descending);
    }

    public SortKeys(String fieldName, Boolean descending, Class fieldClass) {
        addField(fieldName, fieldClass, descending);
    }

    public SortKeys addField(String fieldName) {
        return addField(fieldName, null, false);
    }

    public SortKeys addField(String fieldName, Class fieldClass) {
        return addField(fieldName, fieldClass, false);
    }

    public SortKeys addField(String fieldName, Boolean descending) {
        return addField(fieldName, null, descending);
    }

    public SortKeys addField(String fieldName, Class fieldClass, Boolean descending) {

        if (sortFields == null || sortFields.isEmpty()) {
            sortFields = new ArrayList<SortField>();
        }
        sortFields.add(new SortField(fieldName, fieldClass, descending));
        return this;
    }

    public List<SortField> getSortFields() {
        return sortFields;
    }

    @Override
    public String toString() {
        return "SortKeys{" +
                "sortFields=" + sortFields +
                '}';
    }
}
