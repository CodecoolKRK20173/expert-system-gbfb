//package com.codecool.expertsystem.rules;

import java.util.List;

public abstract class Value {
    private List<String> inputPattern;
    private boolean selectionType;
    
    public List<String> getInputPattern() {
        return this.inputPattern;
    }

    public boolean getSelectionType() {
        return this.selectionType;
    }
    
    public void setSelectionType(boolean selectionType) {
        this.selectionType = selectionType;
    }

    public void setInputPattern(List<String> inputPattern) {
        this.inputPattern = inputPattern;
    }
    
}