package com.yoneforcode.eczanedemo.controller;

import com.yoneforcode.eczanedemo.entity.Pharmacy;
import com.yoneforcode.eczanedemo.service.PharmacySearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
public class PharmacyController {

    private final PharmacySearchService pharmacySearchService;

    public PharmacyController(PharmacySearchService pharmacySearchService) {
        this.pharmacySearchService = pharmacySearchService;
    }

    @GetMapping("/nearby")
    public ResponseEntity<List<Pharmacy>> findNearbyPharmacies(@RequestParam double latitude, @RequestParam double longitude, @RequestParam int radius) {
        List<Pharmacy> nearbyPharmacies = pharmacySearchService.findNearbyPharmacies(latitude, longitude, radius);
        if (nearbyPharmacies != null && !nearbyPharmacies.isEmpty()) {
            return new ResponseEntity<>(nearbyPharmacies, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

        }
    }


