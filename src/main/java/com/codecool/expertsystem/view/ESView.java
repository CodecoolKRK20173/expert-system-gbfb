package com.codecool.expertsystem.view;

import java.util.List;
import com.codecool.expertsystem.rules.*;

public class ESView {
    public static void displayQuestion(Question question) {
        List<Value> availableValues = question.getAnswer().getValues();
        String availableAnswers = "   Options: ";

        for (Value value : availableValues) {
            for (String s : value.getInputPattern()) {
                availableAnswers += s + ", ";
            }
        }

        System.out.println(question.getQuestion());
        System.out.println(availableAnswers);
    }
}