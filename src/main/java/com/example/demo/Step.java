package com.example.demo;

import java.util.ArrayList;

public class Step {

    private String title;
    private ArrayList<Step> subSteps;

    public Step() {
    }

    public Step(String title, ArrayList<Step> subSteps) {
        this.title = title;
        this.subSteps = subSteps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Step> getSubSteps() {
        return subSteps;
    }

    public void setSubSteps(ArrayList<Step> subSteps) {
        this.subSteps = subSteps;
    }
}
