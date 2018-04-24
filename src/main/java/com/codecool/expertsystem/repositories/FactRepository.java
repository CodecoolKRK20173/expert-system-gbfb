package com.codecool.expertsystem.repositories;

import com.codecool.expertsystem.facts.Fact;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Iterator;

public class FactRepository {
    private Map<Integer, Fact> repository;
    private Iterator<Fact> factIterator;

    public FactRepository() {
        this.repository = new LinkedHashMap<>();
        this.factIterator = new FactIterator();
    }

    public void addQuestion(Fact fact) {
        this.repository.put(this.repository.size(), question);
    }

    public Iterator<Fact> getIterator() {
        return this.factIterator;
    }

    private class FactIterator implements Iterator<Fact> {
        private int index;

        private FactIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < repository.size();

        }

        @Override
        public Fact next() {
            return repository.get(this.index++);
        }
    }
}