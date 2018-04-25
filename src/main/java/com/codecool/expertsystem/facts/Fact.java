package com.codecool.expertsystem.facts;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Fact {

    private String id;
    private String description;
    private Map<String, Boolean> IdValueMap;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
        this.IdValueMap = new HashMap<>();
    }

    public Set<String> getIdSet() {
        return this.IdValueMap.keySet();
    }

    public void setFactValueById(String id, boolean value) {
        this.IdValueMap.put(id, value);
    }

    public boolean getValueById(String id) {
        for (String key : this.IdValueMap.keySet()) {
            if (key.equals(id)) {
                return this.IdValueMap.get(id);
            }
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }
}