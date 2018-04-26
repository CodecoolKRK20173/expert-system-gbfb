package com.codecool.expertsystem;

import com.codecool.expertsystem.controller.ESProvider;
import com.codecool.expertsystem.parsers.FactParser;
import com.codecool.expertsystem.parsers.RuleParser;

public class Main {
    public static void main( String[] args ) {
        ESProvider expertSystem = new ESProvider(new FactParser(), new RuleParser());
        expertSystem.collectAnswers();
        expertSystem.evaluate();
    }
}
