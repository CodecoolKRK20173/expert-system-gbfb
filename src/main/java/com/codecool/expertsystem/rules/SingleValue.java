//package com.codecool.expertsystem.rules;

import java.util.List;
import java.util.ArrayList;

public class SingleValue extends Value {

    public SingleValue(String param, boolean selectionType) {
        initSingleValue(param);
    }

    private void initSingleValue(String param) {
        setSelectionType(true);
        List<String> inputPattern = new ArrayList<>();
        inputPattern.add(param);
        setInputPattern(inputPattern);
    }
}