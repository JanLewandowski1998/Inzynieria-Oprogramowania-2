package com.example.demo;

import java.util.ArrayList;

public class Scenario {

    private String title;
    private ArrayList<String> actors;
    private ArrayList<String> systemActors;
    private ArrayList<Step> steps;

    public Scenario() {
    }

    public Scenario(String title, ArrayList<String> actors, ArrayList<String> systemActors, ArrayList<Step> steps) {
        this.title = title;
        this.actors = actors;
        this.systemActors = systemActors;
        this.steps = steps;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getSystemActors() {
        return systemActors;
    }

    public void setSystemActors(ArrayList<String> systemActors) {
        this.systemActors = systemActors;
    }

    public ArrayList<Step> getSteps() {
        return steps;
    }

    public void setSteps(ArrayList<Step> steps) {
        this.steps = steps;
    }
}
