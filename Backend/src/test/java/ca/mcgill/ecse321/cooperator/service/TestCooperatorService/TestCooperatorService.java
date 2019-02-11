package ca.mcgill.ecse321.cooperator.service.TestCooperatorService;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ca.mcgill.ecse321.cooperator.dao.EvaluationRepository;
import ca.mcgill.ecse321.cooperator.dao.AcceptanceRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import ca.mcgill.ecse321.cooperator.model.Student;
import ca.mcgill.ecse321.cooperator.service.CooperatorService;
import ca.mcgill.ecse321.cooperator.model.Acceptance;
import ca.mcgill.ecse321.cooperator.model.Evaluation;

import org.junit.Test;

public class TestCooperatorService {

	@Autowired
	private CooperatorService service;

	@Autowired
	private EvaluationRepository evaluationRepository;
	@Autowired
	private AcceptanceRepository acceptanceRepository;
	@Autowired
	private StudentRepository studentRepository;

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		studentRepository.deleteAll();
		// Then we can clear the other tables
		acceptanceRepository.deleteAll();
		evaluationRepository.deleteAll();
	}

	@Test
	public void testCreateStudent() {
		assertEquals(0, service.getAllStudents().size()); 

		String name = "john";

		try {
			service.createStudent(01, name, "john.smith@mcgill.ca", "pass123");
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			//System.out.println("Student creation failed!");
			fail();
		}

		List<Student> allPersons = service.getAllStudents();
		
		assertEquals(1, allPersons.size()); //checking whether table is created 
		
		assertEquals(name, allPersons.get(0).getName()); //checking Reading i.e whether student has the correct name in the database
	}

	@Test
	public void testCreatePersonNull() {
		assertEquals(0, service.getAllStudents().size());

		String name = null;
		String error = null;

		try {
			service.createStudent(02,name, "abc@company.com", "password123"); //we are passing name as null to check if input is taken or not
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Student name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllStudents().size());

	}


}
