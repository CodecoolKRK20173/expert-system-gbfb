package com.codecool.expertsystem.parsers;

import com.codecool.expertsystem.facts.*;

import org.w3c.dom.Document;

public class FactParser extends XMLParser {
    FactRepository factsRepo = getFactRepository();

    public FactParser() {
        loadXmlDocument("fact.xml");
    }

    public FactRepository getFactRepository() {
        return new FactRepository;
    }

    private void fillFactsRepo() {

    }

    public Document

}