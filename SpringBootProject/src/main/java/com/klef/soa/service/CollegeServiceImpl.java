package com.klef.soa.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.College;
import com.klef.soa.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService
{

	 @Autowired
	 private CollegeRepository collegerepo;
	
	@Override
	public College addCollege(College c) {
		return collegerepo.save(c);
	}

	@Override
	public College updateCollege(College c) {
		College college = collegerepo.findById(c.getCollegeId()).orElse(null);

	    if (college != null) {
	        college.setName(c.getName());
	        college.setType(c.getType());
	        college.setStatus(c.isStatus());
	        college.setLocation(c.getLocation());

	        return collegerepo.save(college);
	    }

	    return null;
	}

	@Override
	public String deleteCollegeById(Long collegeId) {
		boolean flag = collegerepo.existsById(collegeId);
		if(flag)
		{
			collegerepo.deleteById(collegeId);
			return "College Deleted Successfully";
		}
		else
		{
			return "College ID Not Found";
		}
	}

	@Override
	public List<College> displayAllColleges() {
		 return collegerepo.findAll();
	}

	@Override
	public College displayCollegeById(Long collegeId) {
		return collegerepo.findById(collegeId).orElse(null);
	}

	@Override
	public List<College> displayCollegeByName(String name) {
	
		return collegerepo.findByName(name);
	}

	@Override
	public List<College> displayCollegeByType(String type) {
		
		return collegerepo.findByType(type);
	}

}
