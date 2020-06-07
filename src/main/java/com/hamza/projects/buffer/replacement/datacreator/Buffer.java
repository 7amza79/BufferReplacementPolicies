package com.hamza.projects.buffer.replacement.datacreator;

import java.util.ArrayList;

public class Buffer {

    private final ArrayList<Case> data;

    private final int bufferLimitSize;

    public Buffer(int size) {
        bufferLimitSize = size;
        this.data = new ArrayList<>();
    }

    public void insertCase(Case a, int place) {
        this.data.set(place, a);
    }

    public void insertCase(Case a) {
        this.data.add(a);
    }

    public Case elementAt(int i) {
        return this.data.get(i);
    }

    public boolean isFull() {
        return this.data.size() == this.bufferLimitSize;
    }

    public boolean contains(String caseData) {
        return this.data.stream().anyMatch(aCase -> aCase.getFrame().equals(caseData));
    }

    public int existAt(String caseData) {
        return this.data.indexOf(new Case(caseData));
    }

    public int getBufferSize() {
        return this.data.size();
    }

}
