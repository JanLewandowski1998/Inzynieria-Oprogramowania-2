package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    public ArrayList<String> actors(Scenario scenario) {
        ArrayList<Step> steps = scenario.getSteps();
        ArrayList<String> actors = concatenateTwoLists(scenario.getActors(), scenario.getSystemActors());
        return findSteps(steps, actors);
    }

    private ArrayList<String> findSteps(List<Step> steps, List<String> actors) {
        if (steps.size() == 0) return new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
        for (Step step : steps) {
            if (!(checkIfActorIsOnTheFirstPosition(step.getTitle(), actors) || checkIfActorIsOnTheSecondPosition(step.getTitle(), actors))) {
                list.add(step.getTitle());
            }
            ArrayList<String> list2 = findSteps(step.getSubSteps(), actors);
            list = concatenateTwoLists(list, list2);
        }
        return list;
    }

    private boolean checkIfActorIsOnTheFirstPosition(String s, List<String> actors) {
        if (s == null) {
            return false;
        }
        for (String string : actors) {
            if (s.startsWith(string)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkIfActorIsOnTheSecondPosition(String s, List<String> actors) {
        if (s == null) {
            return false;
        }
        int secondWordPosition = s.indexOf(" ");
        String secondWord = s.substring(secondWordPosition + 1);
        for (String string : actors) {
            if (secondWord.startsWith(string)) {
                return true;
            }
        }
        return false;
    }

    private ArrayList<String> concatenateTwoLists(List<String> list1, List<String> list2) {
        ArrayList<String> list = new ArrayList<>();
        for (String s : list1) {
            list.add(s);
        }
        for (String s : list2) {
            list.add(s);
        }
        return list;
    }
}
