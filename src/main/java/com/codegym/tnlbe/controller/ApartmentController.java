package com.codegym.tnlbe.controller;

import com.codegym.tnlbe.entity.Apartment;
import com.codegym.tnlbe.entity.LandLord;
import com.codegym.tnlbe.service.ApartmentService;
import com.codegym.tnlbe.service.LandLordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;
    @Autowired
    private LandLordService landLordService;

    @RequestMapping(value = "/landlord", method = RequestMethod.GET)
    public ResponseEntity<List<LandLord>> landLord(){
        return new ResponseEntity<>(landLordService.findAllLandLord(), HttpStatus.OK);
    }

    @RequestMapping( value = "/apartments", method = RequestMethod.GET)
    public ResponseEntity<List<Apartment>> getApartment(){
        return new ResponseEntity<>(apartmentService.findAllApartment(), HttpStatus.OK);
    }

    @RequestMapping( value = "/create-apartment", method = RequestMethod.POST)
    public ResponseEntity<String> createApartment(@RequestBody Apartment apartment){
        apartmentService.saveApartment(apartment.getId(), apartment);
        return new ResponseEntity<>("Apartment Created", HttpStatus.CREATED);
    }

    @RequestMapping( value = "/delete-apartment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteApartment(@PathVariable("id") Long id){
        apartmentService.deleteApartment(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @RequestMapping( value = "/edit-apartment/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> editApartment(@PathVariable("id") Long id, @RequestBody Apartment apartment){
        apartmentService.deleteApartment(id);
        apartment.setId(id);
        apartmentService.saveApartment(id, apartment);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

}
