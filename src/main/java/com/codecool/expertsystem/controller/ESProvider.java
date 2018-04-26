package com.codecool.expertsystem.controller;

import com.codecool.expertsystem.parsers.*;
import com.codecool.expertsystem.repositories.FactRepository;
import com.codecool.expertsystem.repositories.RuleRepository;
import com.codecool.expertsystem.rules.*;
import com.codecool.expertsystem.facts.*;

import java.util.*;

public class ESProvider {
    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    private Map<String, Boolean> userAnswers;

    private Scanner reader;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factRepository = factParser.getRepository();
        this.ruleRepository = ruleParser.getRepository();
        this.userAnswers = new HashMap<>();
    }

    public void collectAnswers() {
        Iterator<Question> questionIterator = this.ruleRepository.getIterator();

        while (questionIterator.hasNext()) {
            Question currentQuestion = questionIterator.next();

            this.reader = new Scanner(System.in);

            System.out.println(currentQuestion.getQuestion());
            String userAnswer = reader.nextLine();

            boolean evaluatedAnswer = currentQuestion.getEvaluatedAnswer(userAnswer);

            this.userAnswers.put(currentQuestion.getId(), evaluatedAnswer);
        }
    }

    public void evaluate() {
        Iterator<Fact> factIterator = this.factRepository.getIterator();

        while (factIterator.hasNext()) {
            Fact currentlyCheckedFact = factIterator.next();
            if (testMatch(currentlyCheckedFact)) {
                System.out.println("You should buy a " + currentlyCheckedFact.getDescription());
            }
        }
    }

    private boolean testMatch(Fact fact) {
        Set<String> factValueIdSet = fact.getIdSet();

        for (String id : factValueIdSet) {
            if (!this.userAnswers.get(id).equals(fact.getValueById(id))) {
                return false;
            }
        }

        return true;
    }
}
