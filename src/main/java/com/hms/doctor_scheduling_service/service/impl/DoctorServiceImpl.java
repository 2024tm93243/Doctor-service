package com.hms.doctor_scheduling_service.service.impl;

import com.hms.doctor_scheduling_service.model.Doctor;
import com.hms.doctor_scheduling_service.repository.DoctorRepository;
import com.hms.doctor_scheduling_service.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<Doctor> getDoctorsByDepartment(String department) {
        return doctorRepository.findByDepartment(department);
    }

    @Override
    public boolean checkSlotAvailability(Long doctorId, String slot) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        // Placeholder logic for slot availability
        return doctor.isPresent() && slot != null && !slot.isEmpty();
    }

    @Override
    public Doctor getDoctorById(Long doctorId) {
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);
        return doctor.orElseThrow(() -> new RuntimeException("Doctor not found with ID: " + doctorId));
    }
}