package com.codecool.expertsystem.Question;

import java.util.InputMismatchException;
import java.util.List;

public class Answer {
    private List<Value> values;

    public Answer() {
        values = new ArrayList<Value>();
    }

    private String[] splitInput(String userInput) {
        String[] splittedInput = userInput.split(",");
        return splittedInput;
    }

    public boolean evaluateAnswerByInput(String userInput) {
        String[] splittedInput = splitInput(userInput);

        for (Value value : this.values) {
            for (String s : splittedInput) {
                if (value.getInputPattern().contains(s)) {
                    return value.getSelectionType();
                    }
                else {
                    throw new InputMismatchException(e); {
                        System.out.println("Input pattern mismatch");
                    }
                }
            }
        }
        return false;
    }

    public void addValue(Value value) {
        values.add(value);
    }
}

