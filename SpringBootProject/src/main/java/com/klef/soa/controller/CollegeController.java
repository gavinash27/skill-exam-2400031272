package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.College;

import com.klef.soa.service.CollegeService;

@RestController
@RequestMapping("/college")
public class CollegeController {

	  @Autowired
	  public CollegeService service;
	  
	  @GetMapping("/")
	  public String demo()
	  {
		  return "Spring Boot Project";
	  }
	  
	  //Add College
	  @PostMapping("/add")
	  public ResponseEntity<College> addCollege(@RequestBody College c) {
	      College college = service.addCollege(c);
	      return ResponseEntity.status(201).body(college);
	  }
	  
	// Display All Colleges
		@GetMapping("/displayall")
		public ResponseEntity<List<College>> displayAllColleges()
		{
			List<College> colleges = service.displayAllColleges();
			return ResponseEntity.status(200).body(colleges);
		}
		
	// Display College By ID
		@GetMapping("/display")
		public ResponseEntity<?> displayCollegeById(@RequestParam Long collegeId)
		{
			College college = service.displayCollegeById(collegeId);

			if (college != null)
			{
				return ResponseEntity.status(200).body(college);
			}
			else
			{
				return ResponseEntity.status(404).body("College ID Not Found");
			}
		}
		
		// Update College
		@PutMapping("/update")
		public ResponseEntity<?> updateCollege(@RequestBody College college)
		{
			College c = service.updateCollege(college);

			if (c != null)
			{
				return ResponseEntity.ok(c);
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("College ID Not Found");
			}
		}
		
		// Delete College By ID
		@DeleteMapping("/delete/{collegeId}")
		public ResponseEntity<String> deleteCollegeById(@PathVariable Long collegeId)
		{
			String message = service.deleteCollegeById(collegeId);
			return new ResponseEntity<>(message, HttpStatus.OK);
		}
		
		//Find College By Name
		@GetMapping("/displayByName")
		public ResponseEntity<?> displayCollegeByName(@RequestParam String name)
		{
			List<College> college = service.displayCollegeByName(name);

			if (college != null)
			{
				return ResponseEntity.status(200).body(college);
			}
			else
			{
				return ResponseEntity.status(404).body("College Name Not Found");
			}
		}
		
		//Find College by Type
		@GetMapping("/displayByType")
		public ResponseEntity<?> displayCollegeByType(@RequestParam String type)
		{
			List<College> college = service.displayCollegeByType(type);

			if (college != null)
			{
				return ResponseEntity.status(200).body(college);
			}
			else
			{
				return ResponseEntity.status(404).body("College Type Not Found");
			}
		}
}
