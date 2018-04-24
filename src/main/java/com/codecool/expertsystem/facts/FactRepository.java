package com.codecool.expertsystem.facts;

import java.util.HashMap;
import java.util.Iterator;

public class FactRepository {
    private Map<Integer, Fact> factRepository;
    private Iterator<Fact> factIterator;

    public FactRepository() {
        this.factRepository = new HashMap<>();
        this.factIterator = new FactIterator();
    }

    public void addFact(Fact fact) {
        this.factRepository.put(factRepository.size(), fact);
    }

    public Iterator<Fact> getIterator() {
        return this.factIterator;
    }

    private class FactIterator implements Iterator<Integer> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return this.index < factRepository.size();
        }

        @Override
        public Fact next() {
           return factRepository.get(this.index++);
        }
    }
}
