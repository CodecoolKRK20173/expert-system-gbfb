package com.codecool.expertsystem.repositories;

import com.codecool.expertsystem.rules.Question;

import java.util.Map;
import java.util.LinkedHashMap;

import java.util.Iterator;

public class RuleRepository {
    private Map<Integer, Question> repository;
    private Iterator<Question> questionIterator;

    public RuleRepository() {
        this.repository = new LinkedHashMap<>();
        this.questionIterator = new QuestionIterator();
    }

    public void addQuestion(Question question) {
        this.repository.put(this.repository.size(), question);
    }

    public Iterator<Question> getIterator() {
        return this.questionIterator;
    }

    private class QuestionIterator implements Iterator<Question> {
        private int index;

        private QuestionIterator() {
           this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < repository.size();

        }

        @Override
        public Question next() {
            return repository.get(this.index++);
        }
    }
}