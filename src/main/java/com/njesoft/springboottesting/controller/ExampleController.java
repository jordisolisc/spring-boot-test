package com.njesoft.springboottesting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @RequestMapping("/example")
    public String example(@RequestParam(name = "parameter", defaultValue = "jordinete") String parameter){
        return String.format("This is an example %s", parameter);
    }
}
