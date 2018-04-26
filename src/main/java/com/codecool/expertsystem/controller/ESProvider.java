import java.util.Map;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.Iterator;

import com.codecool.expertsystem.parsers.*;
import com.codecool.expertsystem.rules.*;
import com.codecool.expertsystem.facts.*;

public class ESProvider {
    private FactParser factParser;
    private RuleParser ruleParser;
    private Map<String, Boolean> userAnswers;
    private Scanner scanner;

    public ESProvider(FactParser factParser, RuleParser ruleParser) {
        this.factParser = factParser;
        this.ruleParser = ruleParser;
    }

    public void collectAnswers() {
        this.scanner = new Scanner(System.in);
        this.userAnswers = new HashMap<>();
        Iterator iterator = this.ruleParser.getRepository().getIterator();

        while (iterator.hasNext()) {
            Question question = iterator.next();
            while (true) {
                try {
                    System.out.println(question.getQuestion());
                    String input = scanner.nextLine();
                    Answer answer = question.getEvaluatedAnswerByInput(input);
                    this.userAnswers.put(question.getId(), answer);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public boolean getAnswerByQuestion(String question) {

    }

    public String evaluate() {
        Iterator iterator = this.factParser.getRepository().getIterator();
        while(iterator.hasNext()) {
            Fact fact = iterator.next();
            for (String answerId : this.userAnswers.keySet()) {
                for (String factId : fact.getIdSet()) {
                    if (answerId.equals(factId)) {
                        if (this.userAnswers.get(answerId) == fact.getValueById(factId)) {
                            System.out.println("this agrees");
                        }
                        else {
                            System.out.println("this doesn't agree");
                        }
                    }
                }
            }
        }
    }
}
