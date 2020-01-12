package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordsService {

    public int countKeywords(List<Step> steps) {
        int howMany = 0;
        if (steps.size() == 0) {
            return howMany;
        }
        for (Step step : steps) {
            howMany = countKeywords(step.getSubSteps()) + howMany;
            String title = step.getTitle();
            if (title.startsWith("IF") || title.startsWith("FOR EACH")) {
                howMany = howMany + 1;
            }
        }
        return howMany;
    }
}
