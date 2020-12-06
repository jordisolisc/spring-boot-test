package com.njesoft.springboottesting.unit.controller;

import com.njesoft.springboottesting.controller.ExampleController;
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