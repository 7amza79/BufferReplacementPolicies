package com.hamza.projects.buffer.replacement.datacreator;

import java.util.ArrayList;

public class Buffer {


    private final int size;
    private final ArrayList<Case> data;


    public Buffer(int size) {

        this.data = new ArrayList<>();
        this.size = size;
        for (int i = 0; i < size; i++) {
            data.add(new Case());
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

    public int getSize() {
        return size;
    }

    public void bufferInit() {
        for (int i = 0; i < this.size; i++) {
            Case a = new Case("-1", 0);
            this.insertCase(a, i);
        }
    }
}
