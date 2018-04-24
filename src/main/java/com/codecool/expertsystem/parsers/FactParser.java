package com.codecool.expertsystem.parsers;

import com.codecool.expertsystem.facts.*;

import org.w3c.dom.Document;

public class FactParser extends XMLParser {
    FactRepository factsRepo = new FactRepository;

    public FactParser() {
        loadXmlDocument("facts.xml");

    public FactRepository getFactRepository() {
        return new FactRepository;
    }

    private void fillFactsRepo() {

    }
}