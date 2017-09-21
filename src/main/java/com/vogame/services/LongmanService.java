package com.vogame.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LongmanService {


    public String getLongmanDefinition(String word) {
        String resultDefinition = "";
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        Object obj = restTemplate
                .getForObject("http://api.pearson.com/v2/dictionaries/lasde/entries?headword=" + word,
                Object.class);
        Map objMap = (Map)obj;
        List resultsList = (List)objMap.get("results");
        for(Object result : resultsList) {
            Map resultMap = (Map)result;
            String pos = (String)resultMap.get("part_of_speech");
            resultDefinition += pos;
            List senses = (List)resultMap.get("senses");
            if(senses != null) {
                for (Object sense : senses) {
                    Map senseMap = (Map) sense;
                    List<String> definitions = (List<String>) senseMap.get("definition");
                    for (String definition : definitions) {
                        resultDefinition += " | " + definition;
                    }
                }
            }
            resultDefinition += " || ";
        }

        return resultDefinition;
    }

}
