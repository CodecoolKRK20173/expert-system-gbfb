package com.codecool.expertsystem;

import com.codecool.expertsystem.facts.Fact;
import com.codecool.expertsystem.parsers.*;
import com.codecool.expertsystem.repositories.FactRepository;
import com.codecool.expertsystem.repositories.RuleRepository;
import com.codecool.expertsystem.rules.Answer;
import com.codecool.expertsystem.rules.Question;

import java.util.Iterator;
import java.util.Set;

public class ParserTest {
    public static void run() {
        System.out.println("====Rules====");
        RuleParser ruleParser = new RuleParser();
        RuleRepository ruleRepository = ruleParser.getRepository();

        Iterator<Question> ruleIterator = ruleRepository.getIterator();

        while (ruleIterator.hasNext()) {
            Question question = ruleIterator.next();

            System.out.println("ID: " + question.getId());
            System.out.println("Treść: " + question.getQuestion());

            Answer answer = question.getAnswer();

        }

        System.out.println("====Facts====");
        FactParser factParser = new FactParser();
        FactRepository factRepository = factParser.getRepository();

        Iterator<Fact> factIterator = factRepository.getIterator();

        while (factIterator.hasNext()) {
            Fact fact = factIterator.next();

            System.out.println("Opis: " + fact.getDescription());
            System.out.println("ID set: " + fact.getIdSet());

            Set<String> idSet = fact.getIdSet();

            for (String id : idSet) {
                System.out.println("Value by id: " + fact.getValueById(id));
            }
        }
    }
}