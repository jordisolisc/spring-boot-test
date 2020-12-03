package com.njesoft.springboottesting.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleControllerTest {

    @Test
    public void example(){

        ExampleController exampleController = new ExampleController();
        String response = exampleController.example("jordi");
        assertEquals("This is an example jordi", response);

    }

}