package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.College;

public interface CollegeService {
     
	College addCollege(College c);
	College updateCollege(College c);
	String deleteCollegeById(Long collegeId);
	List<College> displayAllColleges();
	College displayCollegeById(Long collegeId);
	List<College> displayCollegeByName(String name);
	List<College> displayCollegeByType(String type);
}
