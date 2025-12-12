package com.demo.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Patient;
import com.demo.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService ps;
	
	@PostMapping("add")
	public void add(@RequestBody Patient p) {
		ps.add(p);
	}

	@GetMapping("display")
	public List<Patient>display(){
		return ps.display();
	}
	
	@GetMapping("searchById = {id}")
	public Patient serachById(@PathVariable Integer id) {
		return ps.searchById(id);
	}
	
	@PutMapping("update = {id}")
	public Patient update(@PathVariable Integer id, @RequestBody Patient p) {
		return ps.update(id, p);
	}
	
	@DeleteMapping("delete = {id}")
	public void delete(@PathVariable Integer id) {
		ps.delete(id);
	}
	
	@GetMapping("searchByName = {name}")
	public Patient searchByName(@PathVariable String name) {
		return ps.searchByName(name);
	}
	
	@GetMapping("findByAge = {age}")
	public Patient findByAge(@PathVariable Integer age) {
		return ps.findByAge(age);
	}
	
	
	@GetMapping("findByDate = {date}")
	public Patient findByDate(@PathVariable String date) {
		return ps.findByDate(date);
	}
	
	@PostMapping("search = {id}")
	public ResponseEntity<?> search(@PathVariable Integer id){
		Patient result = ps.search(id);
		return new ResponseEntity<Patient>(result, HttpStatus.OK);
	}
	
	@GetMapping("searchByGender = {gender}")
	public List searchByGender(@PathVariable String gender) {
		return ps.searchByGender(gender);
	}
	
	
	
}
