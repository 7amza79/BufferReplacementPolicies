/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamza.projects.buffer.replacement.datacreator;

import java.util.Objects;

/**
 * @author Hamza
 */
public class Case {

    private final String frame;
    private int flag;

    public String getFrame() {
        return frame;
    }

    public int getFlag() {
        return flag;
    }

    public Case(String frame, int flag) {
        this.frame = frame;
        this.flag = flag;
    }

    public Case(String frame){
        this.frame = frame;
    }

    public Case() {
        this.frame = "-1";
        this.flag = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Case aCase = (Case) o;
        return frame.equals(aCase.frame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(frame);
    }
}
