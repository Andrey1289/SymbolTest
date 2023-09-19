package com.example.andrey.controller;

import com.example.andrey.service.CountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
    @RequestMapping("api/v1/count")
public class LineController {
    final CountService countService;

    public LineController(CountService countService) {
        this.countService = countService;
    }
@GetMapping("/string")
    public ResponseEntity<?> countInnerSymbol(@RequestParam String inputString){
          if(inputString == null || inputString.isEmpty()){
              return ResponseEntity.badRequest().body("Empty request field");
          }
      return new ResponseEntity<>(countService.countSymbol(inputString),HttpStatus.OK);

    }
}
