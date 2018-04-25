package com.codecool.expertsystem.parsers;

import com.codecool.expertsystem.facts.Fact;
import com.codecool.expertsystem.repositories.FactRepository;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class FactParser extends XMLParser {
    FactRepository factsRepo = getFactRepository();

    public FactParser() {
        loadXmlDocument("facts.xml");
        parseDocumentToRepository();
    }

    public FactRepository getFactRepository() {
        return new FactRepository();
    }

    @Override
    public void parseDocumentToRepository() {
        NodeList factsList = getDocument().getElementsByTagName("Fact");
        String id, description, perk;
        boolean value;

        for(int i = 0; i < factsList.getLength(); i++) {
            Node node = factsList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE) {

                Element element = (Element) node;

                id = element.getAttribute("id");
                Element descriptionElement = (Element) element.getElementsByTagName("Description")
                                                              .item(0);
                description = descriptionElement.getAttribute("value");

//                System.out.println("ID: " + id);
//                System.out.println("Description: " + description);
                NodeList evalsList = element.getElementsByTagName("Eval");

                Fact fact = new Fact(id, description);

                for(int j = 0; j < evalsList.getLength(); j++) {
                    Node evalNode = evalsList.item(j);
                    Element evalElement = (Element) evalNode;

                    perk = evalElement.getAttribute("id");
                    value = Boolean.valueOf(evalElement.getTextContent());
//                    System.out.println("Perk: " + perk + "\n" + "Value: " + value);
//                    System.out.println("");

                    fact.setFactValueById(perk, value);
                }
            factsRepo.addFact(fact);
            }
        }
    }

}