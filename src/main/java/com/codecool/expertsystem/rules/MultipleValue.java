//package com.codecool.expertsystem.rules;

import java.util.List;
import java.util.ArrayList;

public class MultipleValue extends Value {

    public MultipleValue(List<String> params, boolean selectionType) {
        setSelectionType(true);
        List<String> inputPattern = new ArrayList<>();
        for (String param : params) {
            inputPattern.add(param);
        }
        setInputPattern(inputPattern);
    }
}