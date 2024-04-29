package com.yoneforcode.eczanedemo.repository;

import com.yoneforcode.eczanedemo.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
}

