/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hamza.projects.buffer.replacement.datacreator;

/**
 * @author Hamza
 */
public class Case {

    private String frame;
    private int flag;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }


    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public Case(String frame, int flag) {
        this.frame = frame;
        this.flag = flag;
    }

    public Case() {
        this.frame = "-1";
        this.flag = 0;
    }


}
