package com.njesoft.springboottesting.unit.controller;

import com.njesoft.springboottesting.controller.ExampleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@WebMvcTest(ExampleControllerTest.class)
public class ExampleControllerTest {

    @Test
    public void example(){

        ExampleController exampleController = new ExampleController();
        String response = exampleController.example("jordi");
        assertEquals("This is an example jordi", response);

    }

}