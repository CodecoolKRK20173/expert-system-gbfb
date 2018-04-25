package com.codecool.expertsystem.rules;

public class Question {

    private String Id;
    private String question;
    private Answer answer;

    public Question(String Id, String question, Answer answer) {
        this.Id = Id;
        this.question = question;
        this.Answer = answer;
    }

    public boolean getEvaluatedAnswer(String input) {
        return answer.evaluateAnswerByInput(input);
    }

    public String getId() {
        return Id;
    }

    public String getQuestion() {
        return question;
    }

    public getAnswer() {
        return answer;
    }
}