package com.codecool.expertsystem.parsers;

import com.codecool.expertsystem.repositories.RuleRepository;

import com.codecool.expertsystem.rules.Question;
import com.codecool.expertsystem.rules.Answer;
import com.codecool.expertsystem.rules.MultipleValue;
import com.codecool.expertsystem.rules.SingleValue;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.Arrays;

public class RuleParser extends XMLParser {
    private RuleRepository repository;

    public RuleParser() {
        this.repository = new RuleRepository();
        loadXmlDocument("rules.xml");
        parseDocumentToRepository();
    }

    @Override
    public void parseDocumentToRepository() {
        NodeList rules = this.getDocument().getElementsByTagName("Rule");

        for (int i = 0; i < rules.getLength(); i++) {
            Element rule = (Element) rules.item(i);

            // Rule ID
            String ruleId = rule.getAttribute("id");
            // Question content
            String questionContent = rule.getElementsByTagName("Question")
                                         .item(0)
                                         .getTextContent();

            // Question's possible answers
            Answer answer = new Answer();

            Element answerTag = (Element) rule.getElementsByTagName("Answer")
                                              .item(0);

            NodeList selections = answerTag.getElementsByTagName("Selection");
            for (int j = 0; j < selections.getLength(); j++) {
                Element selection = (Element) selections.item(j);
                boolean selectionValue = Boolean.valueOf(selection.getAttribute("value"));

                NodeList answerValues = selection.getChildNodes();
                for (int k = 0; k < answerValues.getLength(); k++) {
                    Node answerNode = answerValues.item(k);
                    if (answerNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element answerValue = (Element) answerNode;
                        String valueType = answerValue.getTagName();

                        if (valueType.equals("SingleValue")) {
                            answer.addValue(new SingleValue(answerValue.getAttribute("value"), selectionValue));
                        } else if (valueType.equals("MultipleValue")) {
                            String[] values = answerValue.getAttribute("value").split(", ");
                            answer.addValue(new MultipleValue(Arrays.asList(values), selectionValue));
                        }
                    }
                }
            }

            // Make new question and add it to repository
            Question question = new Question(ruleId, questionContent, answer);
            this.repository.addQuestion(question);
        }
    }

    public RuleRepository getRepository() {
        return this.repository;
    }
}