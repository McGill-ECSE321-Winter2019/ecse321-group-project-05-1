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

//import ca.mcgill.ecse321.cooperator.dao.EvaluationRepository;
//import ca.mcgill.ecse321.cooperator.dao.AcceptanceRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import ca.mcgill.ecse321.cooperator.dao.CoopRepository;
import ca.mcgill.ecse321.cooperator.model.Coop;
import ca.mcgill.ecse321.cooperator.model.Student;
import ca.mcgill.ecse321.cooperator.service.CooperatorService;
//import ca.mcgill.ecse321.cooperator.model.Acceptance;
//import ca.mcgill.ecse321.cooperator.model.Evaluation;

import org.junit.Test;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCooperatorService {

	@Autowired
	private CooperatorService service;

	//@Autowired
	//private EvaluationRepository evaluationRepository;
	//@Autowired
	//private AcceptanceRepository acceptanceRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CoopRepository coopRepository;

	@After
	public void clearDatabase() {
		// First, we clear registrations to avoid exceptions due to inconsistencies
		studentRepository.deleteAll();
		// Then we can clear the other tables
		//acceptanceRepository.deleteAll();
		//evaluationRepository.deleteAll();
		coopRepository.deleteAll();
	}

	@Test
	public void testCreateStudent() {
		assertEquals(0, service.getAllStudents().size()); 

		try {
			service.createStudent(01, "john", "john.smith@mcgill.ca", 0, false, true);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			//System.out.println("Student creation failed!");
			fail();
		}

		List<Student> allStudents = service.getAllStudents();
		
		assertEquals(1, allStudents.size()); //checking whether table is created 
		
		assertEquals("john", allStudents.get(0).getName()); //checking Reading i.e whether student has the correct name in the database
	}

	@Test
	public void testCreateStudentNameNull() {
		assertEquals(0, service.getAllStudents().size());

		String name = null;
		String error = null;

		try {
			service.createStudent(02, name, "abc@company.com", 0, false, true); //we are passing name as null to check if input is taken or not
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Student name cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllStudents().size());
	}
	
	@Test
	public void testCreateStudentIDNull() {
		assertEquals(0, service.getAllStudents().size());

		int mcgillID = 0;
		String error = null;

		try {
			service.createStudent(mcgillID, "john", "abc@company.com", 0, false, true); //we are passing name as null to check if input is taken or not
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("ID cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllStudents().size());

	}
	
	@Test
	public void testCreateStudentEmailNull() {
		assertEquals(0, service.getAllStudents().size());

		String email = null;
		String error = null;

		try {
			service.createStudent(02, "john", email, 0, false, true); //we are passing name as null to check if input is taken or not
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}

		// check error
		assertEquals("Email cannot be empty!", error);

		// check no change in memory
		assertEquals(0, service.getAllStudents().size());

	}
	
	@Test
	public void testCreateCoop() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		try {
			service.createCoop(12345, "Montreal", "01052019", "31082019", "summer", "ElementAI", true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			fail();
		}

		List<Coop> allCoops = service.getAllCoops();
		
		assertEquals(1, allCoops.size()); //checking whether table is created 
		
		assertEquals("Montreal", allCoops.get(0).getLocation()); 
	}
	
	@Test
	public void testCreateCoopIDNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		int coopID = 0;
		String error = null;
		try {
			service.createCoop(coopID, "Montreal", "01052019", "31082019", "summer", "ElementAI", true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("ID cannot be empty!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	@Test
	public void testCreateCoopLocationNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		String location = null;
		String error = null;
		try {
			service.createCoop(12345, location, "01052019", "31082019", "summer", "ElementAI", true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("Location cannot be empty!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	@Test
	public void testCreateCoopStartDateNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		String startDate = null;
		String error = null;
		try {
			service.createCoop(12345, "Montreal", startDate, "31082019", "summer", "ElementAI", true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("Start Date cannot be empty!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	@Test
	public void testCreateCoopEndDateNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		String endDate = null;
		String error = null;
		try {
			service.createCoop(12345, "Montreal", "01052019", endDate, "summer", "ElementAI", true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("End Date cannot be empty!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	@Test
	public void testCreateCoopSemesterNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		String semester = null;
		String error = null;
		try {
			service.createCoop(12345, "Montreal", "01052019", "31082019", semester, "ElementAI", true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("Semester cannot be empty!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	@Test
	public void testCreateCoopCompanyNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student s = service.createStudent(1, "john", "john.smith@mail.mcgill.ca", 0, true, false);
		String company = null;
		String error = null;
		try {
			service.createCoop(12345, "Montreal", "01052019", "31082019", "summer", company, true, "", 0, "", "", "", "", "", "", s);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("Company Name cannot be empty!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	@Test
	public void testCreateCoopStudentNull() {
		assertEquals(0, service.getAllCoops().size()); 
		Student r = null;
		String error = null;
		try {
			service.createCoop(12345, "Montreal", "01052019", "31082019", "summer", "ElementAI", true, "", 0, "", "", "", "", "", "", r);
		} catch (IllegalArgumentException e) {
			// Check that no error occurred
			error = e.getMessage();
		}

		assertEquals("You have to specify a student!", error);
		
		assertEquals(0, service.getAllCoops().size()); //checking whether table is created 
		
	}
	
	
	
	
}
