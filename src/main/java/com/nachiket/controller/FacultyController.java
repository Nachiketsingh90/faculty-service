package com.nachiket.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nachiket.model.Faculty;
import com.nachiket.service.FacultyService;


import lombok.extern.java.Log;


@RestController
@RequestMapping("/faculty")
@Log
public class FacultyController {


	@Autowired
	private FacultyService facultyService;
	
	@PostMapping("/registerFaculty")
	public ResponseEntity registerFaculty(@RequestBody Faculty faculty)
	{
		//log.info("FacultyController-->registerFaculty");			
		facultyService.registerFaculty(faculty);		
		//return new ResponseEntity(faculty, new HttpHeaders().set, HttpStatus.CREATED);
		
		return
				ResponseEntity.status(HttpStatus.CREATED).
			
				body("Faculty is created with id:"+faculty.getFacultyID());
	}
	
	@GetMapping("/findFacultyByID/{facultyID}")
	public Faculty findFacultyByID(@PathVariable int facultyID)
	{
		log.info("FacultyController-->findFacultyByID");			
		Faculty obj=facultyService.findFaculty(facultyID);
		System.out.println(obj);
		if(obj!=null)
		{
			log.info("found faculty with id "+facultyID);			
		return  obj;
		}
		else
		{
			String msg="No faculty with given id found";
			log.info("Not found faculty with id "+facultyID);	
			return null;
		}
			
	}
	@PutMapping("/updateFaculty")
	public ResponseEntity updateFaculty(@RequestBody Faculty faculty)
	{
		log.info("FacultyController-->updateFaculty");			
		facultyService.updateFaculty(faculty);		
		//return new ResponseEntity(faculty, new HttpHeaders().set, HttpStatus.CREATED);
		
		return
				ResponseEntity.status(HttpStatus.OK).
			
				body("Faculty is updated with id:"+faculty.getFacultyID());
	}
	
	@DeleteMapping("/deleteFacultyByID/{facultyID}")
	public ResponseEntity deleteFacultyByID(@PathVariable int facultyID)
	{
			log.info("FacultyController-->deleteFacultyByID");			
			String msg=facultyService.deleteFaculty(facultyID);
		
		   	return new ResponseEntity(msg, new HttpHeaders(), HttpStatus.OK);
		
			
	}
	@GetMapping("/findAllFaculty")
	public List<Faculty> findAllFaculty()
	{
		//log.info("FacultyController-->findAllFaculty");		
		System.out.println("findall called");
		List<Faculty> facultyList=facultyService.findAllFaculty();
		if(facultyList.size()==0)
		{
			
		return null;
		}
		else
		{
		
		
			return facultyList;
		}
			
	}
	
}
