package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private StepsService stepsService;
    private KeywordsService keywordsService;
    private ActorService actorService;
    private EnumeratedService enumeratedService;
    private LevelService levelService;

    public Controller(StepsService stepsService, KeywordsService keywordsService, ActorService actorService, EnumeratedService enumeratedService, LevelService levelService) {
        this.stepsService = stepsService;
        this.keywordsService = keywordsService;
        this.actorService = actorService;
        this.enumeratedService = enumeratedService;
        this.levelService = levelService;
    }

    @PostMapping("/steps")
    public int steps(@RequestBody Scenario scenario) {
        ArrayList<Step> steps = scenario.getSteps();
        int howManySteps = stepsService.countSteps(steps);
        return howManySteps;
    }

    @PostMapping("/keywords")
    public int keywords(@RequestBody Scenario scenario) {
        ArrayList<Step> steps = scenario.getSteps();
        int howManyKeywords = keywordsService.countKeywords(steps);
        return howManyKeywords;
    }

    @PostMapping("/actor")
    public List<String> actor(@RequestBody Scenario scenario) {
        ArrayList<String> steps = actorService.actors(scenario);
        return steps;
    }

    @PostMapping("/enumerated")
    public List<String> enumerated(@RequestBody Scenario scenario) {
        ArrayList<String> list = enumeratedService.enumerate(scenario);
        return list;
    }

    @PostMapping("/{level}")
    public ArrayList<Step> level(@RequestBody Scenario scenario, @PathVariable Integer level) {
        ArrayList<Step> steps = levelService.level(scenario, level);
        return steps;
    }
}
