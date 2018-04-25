package com.codecool.expertsystem.rules;

import java.util.List;

public class MultipleValue extends Value {
    public MultipleValue(List<String> params, boolean selectionType) {
        super(selectionType);
        setInputPattern(params);
    }
}