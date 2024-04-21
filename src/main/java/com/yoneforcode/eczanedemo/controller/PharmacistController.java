package com.yoneforcode.eczanedemo.controller;

import com.yoneforcode.eczanedemo.entity.Pharmacist;
import com.yoneforcode.eczanedemo.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pharmacists")
public class PharmacistController {

    private final PharmacistService pharmacistService;

    @Autowired
    public PharmacistController(PharmacistService pharmacistService) {
        this.pharmacistService = pharmacistService;
    }

    @GetMapping
    public ResponseEntity<List<Pharmacist>> getAllPharmacists() {
        List<Pharmacist> pharmacists = pharmacistService.getAllPharmacists();
        return new ResponseEntity<>(pharmacists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pharmacist> getPharmacistById(@PathVariable("id") Long id) {
        Pharmacist pharmacist = pharmacistService.getPharmacistById(id);
        return new ResponseEntity<>(pharmacist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pharmacist> addPharmacist(@RequestBody Pharmacist pharmacist) {
        Pharmacist savedPharmacist = pharmacistService.savePharmacist(pharmacist);
        return new ResponseEntity<>(savedPharmacist, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePharmacist(@PathVariable("id") Long id) {
        pharmacistService.deletePharmacist(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
