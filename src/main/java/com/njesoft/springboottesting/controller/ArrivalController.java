package com.njesoft.springboottesting.controller;

import com.njesoft.springboottesting.model.Arrival;
import com.njesoft.springboottesting.repository.ArrivalRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.njesoft.springboottesting.constant.Constants.ARRIVAL;
import static com.njesoft.springboottesting.constant.Constants.VERSION;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = VERSION + ARRIVAL)
@Api(value = VERSION + ARRIVAL)
public class ArrivalController{

    @Autowired
    private ArrivalRepository arrivalRepository;

    @ApiOperation(value = "Get all arrivals")
    @RequestMapping(value = "all", method = GET)
    @ResponseBody
    public List<Arrival> getAllArrivals() {
        return arrivalRepository.findAll();
    }

    @ApiOperation(value = "Get arrival by ID")
    @RequestMapping(value = "{id}", method = GET)
    @ResponseBody
    public Arrival getArrivalById(@PathVariable(value = "id") int id) {
        return arrivalRepository.findAllById(id);
    }

}


