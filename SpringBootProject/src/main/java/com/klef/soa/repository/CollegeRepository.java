package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {

    List<College> findByName (String name);
    
    List<College> findByType (String type);
}
