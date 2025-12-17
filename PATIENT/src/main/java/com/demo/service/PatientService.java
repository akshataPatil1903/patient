package com.demo.service;

import java.sql.Date;
import java.util.List;



import com.demo.model.Patient;


public interface PatientService {

	void add(Patient p);

	List<Patient> display();

	Patient searchById(Integer id);

	Patient update(Integer id, Patient p);

	void delete(Integer id);

	Patient searchByName(String name);

	Patient findByAge(Integer age);

	Patient findByDate(String date);

	Patient search(Integer id);

	List searchByGender(String gender);

	List<Patient> sortByName();

	List<Patient> sortByAge();

	List<Patient> sortByEmail();

	List<Patient> sortByDate();

	

	

	

//	Patient findByDate(String date);

	

}
