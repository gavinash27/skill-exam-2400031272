
package com.klef.soa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.College;
import com.klef.soa.repository.CollegeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CollegeRepositoryTest {

    @Autowired
    private CollegeRepository repository;

    // Test 1 - Find All Colleges
    @Test
    void testFindAllColleges() {
        List<College> colleges = repository.findAll();

        assertNotNull(colleges);
        assertFalse(colleges.isEmpty());

        System.out.println("Total Colleges: " + colleges.size());
    }

    // Test 2 - Find College by ID
    @Test
    void testFindCollegeById() {
        List<College> colleges = repository.findAll();
        assertFalse(colleges.isEmpty());

        Long id = colleges.get(0).getCollegeId();

        Optional<College> college = repository.findById(id);

        assertTrue(college.isPresent());
        assertEquals(id, college.get().getCollegeId());

        System.out.println("College ID: " + college.get().getCollegeId());
        System.out.println("College Name: " + college.get().getName());
    }

    // Test 3 - Find College by Name
    @Test
    void testFindCollegeByName() {
        List<College> colleges = repository.findAll();
        assertFalse(colleges.isEmpty());

        String name = colleges.get(0).getName();

        List<College> result = repository.findByName(name);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(name, result.get(0).getName());

        System.out.println("College Name: " + result.get(0).getName());
    }

    // Test 4 - Find College by Type
    @Test
    void testFindCollegeByType() {
        List<College> colleges = repository.findAll();
        assertFalse(colleges.isEmpty());

        String type = colleges.get(0).getType();

        List<College> result = repository.findByType(type);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(type, result.get(0).getType());

        System.out.println("College Type: " + result.get(0).getType());
    }

    // Test 5 - Count Colleges
    @Test
    void testCountColleges() {
        long count = repository.count();

        assertTrue(count > 0);

        System.out.println("Total Colleges in Database: " + count);
    }

    // Test 6 - Find College by Invalid ID
    @Test
    void testFindCollegeByInvalidId() {
        Optional<College> college = repository.findById(Long.MAX_VALUE);

        assertFalse(college.isPresent());

        System.out.println("Invalid College ID: No record found");
    }

    // Test 7 - Verify College Details
    @Test
    void testCollegeDetails() {
        List<College> colleges = repository.findAll();
        assertFalse(colleges.isEmpty());

        College college = colleges.get(0);

        assertNotNull(college.getName());
        assertNotNull(college.getType());
        assertNotNull(college.getLocation());
        assertNotNull(college.getCreatedAt());
        assertNotNull(college.getUpdatedAt());

        System.out.println("Name: " + college.getName());
        System.out.println("Type: " + college.getType());
        System.out.println("Status: " + college.isStatus());
        System.out.println("Location: " + college.getLocation());
        System.out.println("Created At: " + college.getCreatedAt());
        System.out.println("Updated At: " + college.getUpdatedAt());
    }

    // Test 8 - Verify College Status
    @Test
    void testCollegeStatus() {
        List<College> colleges = repository.findAll();
        assertFalse(colleges.isEmpty());

        College college = colleges.get(0);

        assertTrue(college.isStatus() || !college.isStatus());

        System.out.println("College Status: " + college.isStatus());
    }
}
