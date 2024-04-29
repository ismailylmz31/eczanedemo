package com.yoneforcode.eczanedemo.controller;

import com.yoneforcode.eczanedemo.entity.Medicine;
import com.yoneforcode.eczanedemo.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/api")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public ResponseEntity<List<Medicine>> getAllMedicines() {
        List<Medicine> medicines = medicineService.getAllMedicines();
        return new ResponseEntity<>(medicines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable("id") Long id) {
        Medicine medicine = medicineService.getMedicineById(id);
        return new ResponseEntity<>(medicine, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine) {
        Medicine savedMedicine = medicineService.saveMedicine(medicine);
        return new ResponseEntity<>(savedMedicine, HttpStatus.CREATED);
    }

    /*@DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedicine(@PathVariable("id") Long id) {
        medicineService.deleteMedicine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } */
    @GetMapping("/medicines")
    public String showMedicines(Model theModel) {
        List<Medicine> medicines = medicineService.getAllMedicines();
        theModel.addAttribute("medicines",medicines);
        return "medicines"; // URL'yi /api/medicines yerine /medicines olarak değiştirin
    }

    @GetMapping("/create-medicine")
    public String showCreateMedicineForm(Model model) {
        model.addAttribute("medicine", new Medicine());
        return "create-medicine";
    }

    @PostMapping("/create-medicine")
    public String createMedicine(@ModelAttribute("medicine") Medicine medicine) {
        medicineService.saveMedicine(medicine);
        return "redirect:medicines";
    }

    @DeleteMapping("/medicines/{id}")
    public String deleteMedicineWithPostman(@PathVariable("id") Long id) {
        medicineService.deleteMedicine(id);

        return "redirect:/api/medicines";
    }



    @GetMapping("/delete-medicine/{id}")
    public String deleteMedicine(@PathVariable("id") Long id) {
        medicineService.deleteMedicine(id);
        return "redirect:/api/medicines";
    }






}

