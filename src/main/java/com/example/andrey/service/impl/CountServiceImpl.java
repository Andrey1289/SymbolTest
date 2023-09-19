package com.example.andrey.service.impl;

import com.example.andrey.service.CountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountServiceImpl implements CountService {

    @Override
    public  Map<Character, Integer> countSymbol(String innerString) {

        char[] innerSymbol = innerString.toLowerCase().toCharArray();
        Map<Character,Integer> innerStringMap = new HashMap<>();
        for(int i = 0; i < innerSymbol.length; i++){
            innerStringMap.merge(innerSymbol[i],1,Integer::sum);
        }

        innerStringMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Character,Integer>comparingByValue())
                .forEach(System.out::println);

        return innerStringMap;
    }

}
