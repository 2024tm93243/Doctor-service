
package com.hms.doctor_scheduling_service.DataSeeder;

import com.hms.doctor_scheduling_service.model.Doctor;
import com.hms.doctor_scheduling_service.repository.DoctorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DoctorRepository doctorRepository;

    public DataSeeder(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<String[]> readCsvFile(String fileName) {
        List<String[]> records = new ArrayList<>();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(","); // Split CSV by commas
                records.add(fields);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return records;
    }

    @Override
    public void run(String... args) {
        List<String[]> doctors = readCsvFile("hms_doctors.csv");

        for (String[] doctorData : doctors) {
            try {
                Doctor doctor = new Doctor();
                doctor.setName(doctorData[1]);
                doctor.setEmail(doctorData[2]);
                doctor.setPhone(doctorData[3]);
                doctor.setSpecialization(doctorData[5]);
                doctor.setDepartment(doctorData[4]);

                doctorRepository.save(doctor);
            } catch (Exception e) {
                System.err.println("Error saving doctor: " + String.join(", ", doctorData));
                e.printStackTrace();
            }
        }
    }
}