package com.njesoft.springboottesting.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@ExtendWith(SpringExtension.class)
@WebMvcTest(ExampleController.class)
class ExampleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void example() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/example");
        MvcResult result = mockMvc.perform(request).andReturn();
        assertEquals("This is an example jordinete", result.getResponse().getContentAsString());
    }

    @Test
    void exampleWithParameter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/example?parameter=jordi")).andExpect(content().string("This is an example jordi"));

    }

}