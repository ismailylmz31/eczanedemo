package com.yoneforcode.eczanedemo.repository;

import com.yoneforcode.eczanedemo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {
    // REPOSİTORY KODLARI İÇİN SPRİNG JPAREPO YETERLİ EK KOD ŞİMDİLİK GEREK YOK
}