package com.codecool.expertsystem.Question;

import java.util.List;

public class Answer {
    private List<Value> values;

    public Answer() {
        values = new ArrayList<Value>();
    }

    public void addValue(Value value) {
        values.add(value);
    }
}

