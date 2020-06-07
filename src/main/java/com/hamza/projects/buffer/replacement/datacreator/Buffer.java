package com.hamza.projects.buffer.replacement.datacreator;

import java.util.ArrayList;

public class Buffer {

    private final ArrayList<Case> data;

    public Buffer(int size) {
        this.data = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            data.add(new Case("-1", 0));
        }

    }

    public void insertCase(Case a, int place) {
        this.data.set(place, a);
    }

    public Case elementAt(int i) {
        return this.data.get(i);
    }

    public boolean exist(String a) {
        return this.data.stream().anyMatch(aCase -> aCase.getFrame().equals(a));
    }

    public int existAt(String caseData) {
        return this.data.indexOf(new Case(caseData));
    }

}
