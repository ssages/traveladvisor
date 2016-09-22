package com.travelAdvisor.core.controller;

import com.travelAdvisor.core.model.TravelInformation;
import com.travelAdvisor.core.service.TravelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by myPc on 19/09/2016.
 */
@RestController
@RequestMapping("travel")
public class TravelController {

    private TravelService service = new TravelService();

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<TravelInformation> travel(@RequestParam(value="origin") String origin, @RequestParam(value="destination") String destination){
        return new ResponseEntity<TravelInformation>(service.travel(origin, destination), HttpStatus.OK);
    }
}
