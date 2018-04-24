package com.codecool.expertsystem.parsers;

import com.codecool.expertsystem.repositories.RuleRepository;

public class RuleParser extends XMLParser {
    private RuleRepository repository;

    public RuleParser() {
        this.repository = new RuleRepository();
        loadXmlDocument("rules.xml");
    }

    @Override
    public void parseDocumentToRepository() {
        // TODO;
    }

    public RuleRepository getRepository() {
        return this.repository;
    }
}