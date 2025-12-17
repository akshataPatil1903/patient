package com.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.exception.IdNotFound;
import com.demo.model.Patient;
import com.demo.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService  {

	@Autowired
	private PatientRepository pr;
	private Object name;

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

	@Override
	public List<Patient> sortByName() {
		// TODO Auto-generated method stub
		List<Patient>list = pr.findAll();
		
		Collections.sort(list, new Comparator<Patient>() {
			public int compare(Patient o1, Patient o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		return list;
	}

	@Override
	public List<Patient> sortByAge() {
		// TODO Auto-generated method stub
		List<Patient>list = pr.findAll();
		
		Collections.sort(list, new Comparator<Patient>() {
			public int compare(Patient o1, Patient o2) {
				return o1.getAge().compareTo(o2.getAge());	
			}
		});
		return list;
	}

	@Override
	public List<Patient> sortByEmail() {
		// TODO Auto-generated method stub
		List<Patient> list = pr.findAll();
		Collections.sort(list, new Comparator<Patient>() {
			public int compare(Patient o1, Patient o2) {
				return o1.getEmail().compareTo(o2.getEmail());
			}
		});
		return list;
	}

	@Override
	public List<Patient> sortByDate() {
		// TODO Auto-generated method stub
		List<Patient> list = pr.findAll();
		Collections.sort(list, new Comparator<Patient>() {
			public int compare(Patient o1, Patient o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
		
		return list;
	}

	

	

}
