package com.hms.doctor_scheduling_service.service;

import com.hms.doctor_scheduling_service.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    List<Doctor> getDoctorsByDepartment(String department);
    boolean checkSlotAvailability(Long doctorId, String slot);

    Doctor getDoctorById(Long doctorId);
}