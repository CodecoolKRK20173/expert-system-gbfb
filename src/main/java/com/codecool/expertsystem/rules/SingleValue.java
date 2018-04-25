package com.codecool.expertsystem.rules;

public class SingleValue extends Value {
    public SingleValue(String param, boolean selectionType) {
        super(selectionType);
        getInputPattern().add(param);
    }
}