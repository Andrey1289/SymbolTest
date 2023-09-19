package com.example.andrey.controller;

import com.example.andrey.InnerlineApplication;
import com.example.andrey.service.CountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest(classes = InnerlineApplication.class)
@AutoConfigureMockMvc
public class LineControllerTest {

 @Autowired
    LineController lineController;

    @Test
    void ReturnsValidResponseEntity(){
       String innerString = "abcd";
        Map<Character,Integer> expected = new HashMap<>();
        expected.put('a',1);
        expected.put('b',1);
        expected.put('c',1);
        expected.put('d',1);

       var responseEntity = lineController.countInnerSymbol(innerString);
        assertNotNull(responseEntity);
        assertEquals(HttpStatus.OK,responseEntity.getStatusCode());
        assertEquals(expected,responseEntity.getBody());

    }
    @Test
    void ResponseOnEmptyString(){
        String emptyString = "";
        var responseEntity = lineController.countInnerSymbol(emptyString);
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
        assertEquals("Empty request field",responseEntity.getBody());
    }
    @Test
    void ResponseOnNullString(){
        String nullString = null;
        var responseEntity = lineController.countInnerSymbol(nullString);
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
        assertEquals("Empty request field",responseEntity.getBody());
    }

}