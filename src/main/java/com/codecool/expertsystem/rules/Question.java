package com.codecool.expertsystem.rules;

public class Question {
    private String Id;
    private String question;
    private Answer answer;

    public Question(String Id, String question, Answer answer) {
        this.Id = Id;
        this.question = question;
        this.answer = answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        return this.answer.evaluateAnswerByInput(input);
    }

    public String getId() {
        return this.Id;
    }

    public String getQuestion() {
        return this.question;
    }

    public Answer getAnswer() {
        return this.answer;
    }
}