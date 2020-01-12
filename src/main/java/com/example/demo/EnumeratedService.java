package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnumeratedService {

    public ArrayList<String> enumerate(Scenario scenario) {
        ArrayList<Step> list = scenario.getSteps();
        return enumerateSteps(list, "");
    }

    private ArrayList<String> enumerateSteps(ArrayList<Step> list, String startsWith) {
        ArrayList<String> result = new ArrayList<>();
        String start;
        for (int i = 0; i < list.size(); i++) {
            String title = list.get(i).getTitle();
            start = startsWith + '-' + (i + 1);
            String tmp = start + ": " + title;
            tmp = tmp.substring(1);
            result.add(tmp);
            ArrayList<String> list2 = enumerateSteps(list.get(i).getSubSteps(), start);
            result = concatenateTwoLists(result, list2);
        }
        return result;
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
