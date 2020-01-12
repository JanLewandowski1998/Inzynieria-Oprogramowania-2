package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepsService {

    public int countSteps(List<Step> steps) {
        int howMany = 0;
        if (steps.size() == 0) {
            return howMany;
        }
        for (Step step : steps) {
            howMany = countSteps(step.getSubSteps()) + howMany + 1;
        }
        return howMany;
    }
}
