package com.hms.doctor_scheduling_service.repository;

import com.hms.doctor_scheduling_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    // Custom query method to find doctors by department
    List<Doctor> findByDepartment(String department);
}