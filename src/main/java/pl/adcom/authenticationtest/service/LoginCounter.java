package pl.adcom.authenticationtest.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginCounter {

    private Map<String, Integer> visitCounter = new HashMap<>();

    public int getAllVisits(String name){
        updateVisitCounter(name);
        return visitCounter.get(name);
    }

    public void updateVisitCounter(String name){

        if(visitCounter.containsKey(name)){
            Integer visitedCount = visitCounter.get(name);
            visitCounter.put(name, visitedCount+1);
        }else{
            visitCounter.put(name, 1);
        }
    }

}