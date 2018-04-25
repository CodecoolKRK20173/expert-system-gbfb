package com.codecool.expertsystem.rules;

import java.util.List;
import java.util.ArrayList;

public class Answer {
    private List<Value> values;

    public Answer() {
        values = new ArrayList<>();
    }

    public boolean evaluateAnswerByInput(String userInput) {
        for (Value value : this.values) {
            for (String pattern : value.getInputPattern()) {
                if (userInput.equals(pattern)) {
                    return value.getSelectionType();
                }
            }
        }
        return false;
    }

    public void addValue(Value value) {
        this.values.add(value);
    }
}

