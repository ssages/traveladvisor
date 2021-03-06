package com.travelAdvisor.core.controller;

import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by myPc on 19/09/2016.
 */
@RestController
@RequestMapping("traveladvisor")
public class TravelController {

    @Autowired
    private TravelService service;

    @RequestMapping(value="travel", method = RequestMethod.GET)
    public ResponseEntity<TravelInformation> travel(@RequestParam(value="origin") String origin, @RequestParam(value="destination") String destination){
        return new ResponseEntity<TravelInformation>(service.travel(origin, destination), HttpStatus.OK);
    }
}
