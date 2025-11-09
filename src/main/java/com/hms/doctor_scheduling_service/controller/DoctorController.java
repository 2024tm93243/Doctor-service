package com.hms.doctor_scheduling_service.controller;

import com.hms.doctor_scheduling_service.model.Doctor;
import com.hms.doctor_scheduling_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Endpoint to list all doctors
    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }

    // Endpoint to filter doctors by department
    @GetMapping("/department/{department}")
    public ResponseEntity<List<Doctor>> getDoctorsByDepartment(@PathVariable String department) {
        List<Doctor> doctors = doctorService.getDoctorsByDepartment(department);
        return ResponseEntity.ok(doctors);
    }

    // Endpoint to check slot availability for a doctor
    @GetMapping("/{doctorId}/availability")
    public ResponseEntity<Boolean> checkSlotAvailability(@PathVariable Long doctorId, @RequestParam String slot) {
        boolean isAvailable = doctorService.checkSlotAvailability(doctorId, slot);
        return ResponseEntity.ok(isAvailable);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        return ResponseEntity.ok(doctor);
    }

}