package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class LevelService {

    public ArrayList<Step> level(Scenario scenario, int level) {
        ArrayList<Step> steps = scenario.getSteps();
        levelScenario(steps, level, 1);
        return steps;
    }

    private void levelScenario(ArrayList<Step> steps, int level, int l) {
        for (Step step : steps) {
            if (level == l) {
                step.getSubSteps().removeAll(step.getSubSteps());
            } else {
                levelScenario(step.getSubSteps(), level, l + 1);
            }
        }
    }
}
