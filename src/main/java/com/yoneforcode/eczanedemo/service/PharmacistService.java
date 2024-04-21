package com.yoneforcode.eczanedemo.service;

import com.yoneforcode.eczanedemo.entity.Pharmacist;
import com.yoneforcode.eczanedemo.repository.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PharmacistService {

    private final PharmacistRepository pharmacistRepository;

    @Autowired
    public PharmacistService(PharmacistRepository pharmacistRepository) {
        this.pharmacistRepository = pharmacistRepository;
    }

    public List<Pharmacist> getAllPharmacists() {
        return pharmacistRepository.findAll();
    }

    public Pharmacist getPharmacistById(Long id) {
        return pharmacistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pharmacist not found with id: " + id));
    }

    public Pharmacist savePharmacist(Pharmacist pharmacist) {
        return pharmacistRepository.save(pharmacist);
    }

    public void deletePharmacist(Long id) {
        pharmacistRepository.deleteById(id);
    }
}
