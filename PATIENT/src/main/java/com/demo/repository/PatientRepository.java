package com.demo.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findByName(String name);

	Patient findByAge(Integer age);

	Patient findByDate(String date);

	List<Patient> searchByGender(String gender);

}
