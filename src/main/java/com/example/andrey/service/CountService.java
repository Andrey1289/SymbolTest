package com.example.andrey.service;

import org.springframework.stereotype.Service;

import java.util.Map;
@Service
public interface CountService {
    public Map<Character,Integer> countSymbol(String innerString);
}
