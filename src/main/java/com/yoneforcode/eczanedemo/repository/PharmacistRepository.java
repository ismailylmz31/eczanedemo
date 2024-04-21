package com.yoneforcode.eczanedemo.repository;

import com.yoneforcode.eczanedemo.entity.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, Long> {

}
