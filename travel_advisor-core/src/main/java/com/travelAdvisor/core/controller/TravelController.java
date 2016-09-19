package com.travelAdvisor.core.controller;

import com.travelAdvisor.core.domain.TravelInformation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by myPc on 19/09/2016.
 */
@RestController
@RequestMapping("travel")
public class TravelController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TravelInformation> travel(@RequestParam(value="origin") String origin, @RequestParam(value="destination") String destination){
        return new ResponseEntity<TravelInformation>(new TravelInformation(origin, destination), HttpStatus.OK);
    }
}
