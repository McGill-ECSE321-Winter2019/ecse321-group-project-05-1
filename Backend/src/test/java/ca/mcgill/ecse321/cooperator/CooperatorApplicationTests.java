package ca.mcgill.ecse321.cooperator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ca.mcgill.ecse321.cooperator.dao.CoopRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.test.context.junit4.SpringRunner;
import ca.mcgill.ecse321.cooperator.controller.CooperatorRestController;
import ca.mcgill.ecse321.cooperator.model.Student;
import ca.mcgill.ecse321.cooperator.service.CooperatorService;
import ca.mcgill.ecse321.cooperator.model.Coop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CooperatorApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Mock
	private StudentRepository studentDao;
	
	@Mock
	private CoopRepository coopDao;
	
	@InjectMocks
	private CooperatorService service;
	
	@Mock
	private CooperatorService serviceMock;
	
	@InjectMocks
	private CooperatorRestController controller;
	
	private Student student;
	private static final int STUDENT_KEY = 1;
	private static final int NONEXISTING_KEY = 0;
	
	private Coop coop;
	private static final int COOP_KEY = 1;
	private static final int NONEXISTINGCOOP_KEY = 0;;
	
	@Before
	public void setMockOutput() {
	  when(studentDao.findBymcgillID(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
	    if(invocation.getArgument(0).equals(STUDENT_KEY)) {
	      Student student = new Student();
	      student.setMcgillID(STUDENT_KEY);
	      return student;
	    } else { 
	      return null;
	    }
	  });
	  
	  when(coopDao.findBycoopID(anyInt())).thenAnswer( (InvocationOnMock invocation) -> {
		    if(invocation.getArgument(0).equals(COOP_KEY)) {
		      Coop coop = new Coop();
		      coop.setCoopID(COOP_KEY);
		      return coop;
		    } else { 
		      return null;
		    }
		  });
	  
	   
	}
	
	@Before
	public void setupMock() {
		student = mock(Student.class);
		coop = mock(Coop.class);
	}
	
	@Test
	public void testMockStudentCreation() {
		assertNotNull(student);
	}

	@Test
	public void testStudentQueryFound() {
	  assertEquals(STUDENT_KEY, service.getStudent(STUDENT_KEY).getMcgillID());
	}
	
	@Test
	public void testMockCoopCreation() {
		assertNotNull(coop);
	}

	@Test
	public void testCoopQueryFound() {
	  assertEquals(COOP_KEY, service.getCoop(COOP_KEY).getCoopID());
	}
	
	

}

