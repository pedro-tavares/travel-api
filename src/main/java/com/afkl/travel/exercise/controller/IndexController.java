package com.afkl.travel.exercise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/travel")
public class IndexController {

    @GetMapping()
    Map<String, String> index(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "travel-api");
        map.put("date", new Date().toString());
        return  map;
    }
}
