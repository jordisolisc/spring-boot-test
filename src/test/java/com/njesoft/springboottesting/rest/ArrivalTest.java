package com.njesoft.springboottesting.rest;

import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import com.njesoft.springboottesting.Application;
import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = Application.class,
        webEnvironment = RANDOM_PORT)
public class ArrivalTest {

    private String HOST_ROOT = "http://localhost/api/1.0/";
    static final String ARRIVAL_ALL = "arrival/all";

    @LocalServerPort
    private int port;

    @Test
    public void checkArrivalEndpointStatus() {
        prepareGet(ARRIVAL_ALL).statusCode(SC_OK);
    }

    @Test
    public void checkSchemaValidity() {
        prepareGet(ARRIVAL_ALL)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/arrival_schema.json"));
    }

    ValidatableResponse prepareGet(String path) {
        return prepareGetDeleteWhen()
                .get(HOST_ROOT + path)
                .then();
    }

    private RequestSpecification prepareGetDeleteWhen() {
        return given()
                .port(port)
                .when();
    }


}
