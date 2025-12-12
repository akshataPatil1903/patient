package com.demo.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.IdNotFound;
import com.demo.model.Patient;
import com.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository pr;

	@Override
	public void add(Patient p) {
		// TODO Auto-generated method stub
		pr.save(p);
	}

	@Override
	public List<Patient> display() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Patient searchById(Integer id) {
		// TODO Auto-generated method stub
		return pr.findById(id).get();
	}

	@Override
	public Patient update(Integer id, Patient p) {
		// TODO Auto-generated method stub
		p.setId(id);
		return pr.save(p);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);

	}

	@Override
	public Patient searchByName(String name) {
		// TODO Auto-generated method stub
		return pr.findByName(name);
	}

	@Override
	public Patient findByAge(Integer age) {
		// TODO Auto-generated method stub
		return pr.findByAge(age);
	}

	@Override
	public Patient search(Integer id) {
		// TODO Auto-generated method stub
		if (pr.existsById(id)) {
			throw new IdNotFound("Id Not Found!!!");
		}
		return pr.findById(id).get();
	}

	@Override
	public List searchByGender(String gender) {
		// TODO Auto-generated method stub
		return pr.searchByGender(gender);
	}

	@Override
	public Patient findByDate(String date) {
		// TODO Auto-generated method stub
		return pr.findByDate(date);
	}

}
