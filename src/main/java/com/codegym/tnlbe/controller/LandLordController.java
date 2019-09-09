package com.codegym.tnlbe.controller;

import com.codegym.tnlbe.entity.Apartment;
import com.codegym.tnlbe.entity.LandLord;
import com.codegym.tnlbe.service.ApartmentService;
import com.codegym.tnlbe.service.LandLordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LandLordController {
    @Autowired
    private LandLordService landLordService;
    @Autowired
    private ApartmentService apartmentService;

    @RequestMapping(value = "/view-landlord/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Apartment>> viewLandLord(@PathVariable("id") Long id, LandLord landLord){
        landLordService.findLandLordById(id);
        List<Apartment> apartments = apartmentService.findAllByLandLord(landLord);
        return new ResponseEntity<>(apartments, HttpStatus.OK );
    }

}
