/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamza.projects.buffer.replacement.datacreator;

import java.util.ArrayList;

/**
 * @author Hamza
 */
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

    public int existAt(String a) {

        int k = 0;
        int pos = -1;
        boolean exist = false;
        while ((k < this.data.size()) && (exist == false)) {
            if (a.equals(this.data.get(k).getFrame())) {

                // re insert the same element with incremented flag

                exist = true;
                pos = k;
                break;
            } else k++;
        }
        return pos;
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
