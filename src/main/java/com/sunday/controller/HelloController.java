package com.sunday.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("name")
    public String name(){
        return "Syed Mohiuddin";
    }

    @GetMapping("owner")
    public String owner(){
        return "Obaid";
    }
}
