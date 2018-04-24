package com.codecool.expertsystem.Question;

import java.util.List;

public class Answer {
    private List<Value> values;

    public Answer() {
        values = new ArrayList<Value>();
    }

    public boolean evaluateAnswerByInput(String userInput) {
        for (Value value : this.values) {
            for (String pattern : value.getInputPattern()) {
                if (userInput.equals(pattern)) {
                    return value.getSelectionType();
                }
            }
            return false;
        }
    }

    public void addValue(Value value) {
        values.add(value);
    }
}

