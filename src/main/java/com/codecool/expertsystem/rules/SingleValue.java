package com.codecool.expertsystem.rules;

import java.util.ArrayList;
import java.util.List;

public class SingleValue extends Value {
    public SingleValue(String param, boolean selectionType) {
        super(selectionType);
        setInputPattern(parseStringToList(param));
    }

    private List<String> parseStringToList (String param) {
        List<String> params = new ArrayList<>();
        params.add(param);

        return params;
    }
}