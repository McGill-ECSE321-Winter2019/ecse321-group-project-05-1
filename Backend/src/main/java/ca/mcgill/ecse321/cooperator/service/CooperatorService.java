package ca.mcgill.ecse321.cooperator.service;

import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ca.mcgill.ecse321.cooperator.dao.CoopRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import ca.mcgill.ecse321.cooperator.model.Coop;
import ca.mcgill.ecse321.cooperator.model.Student;

@Service
public class CooperatorService {
	@Autowired
	StudentRepository studentrepository;
	@Autowired
	CoopRepository cooprepository;
	  
	 
	//---STUDENT CLASS---//
	//CREATE
	@Transactional
	public Student createStudent(int mcgillID, String name, String email, int progress, boolean isEnrolled, boolean reportSubmitted){
		if (name == null || name.trim().length() == 0) {
			throw new IllegalArgumentException("Student name cannot be empty!");
		} 
		if (mcgillID == 0) {
			throw new IllegalArgumentException("ID cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Email cannot be empty!");
		}
		 
		Student student = new Student();
		student.setName(name);
		student.setMcgillID(mcgillID);
		student.setEmail(email);
		student.setProgress(progress);
		student.setIsEnrolled(isEnrolled);
		student.setReportSubmitted(reportSubmitted);
		studentrepository.save(student); //saves student into the database
		
		return student;
	}
	  
	//READ
	@Transactional
	public Student getStudent(int mcgillID) {
		if (mcgillID == 0) {
			throw new IllegalArgumentException("ID cannot be 0");
		}
		return studentrepository.findBymcgillID(mcgillID); //returns student with the primary key id
	}
	//RETRIEVE ALL STUDENTS
	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentrepository.findAll());
	}
	
	//DELETE
	@Transactional
	public Student deleteStudent(int mcgillID) {
		return studentrepository.deleteBymcgillID(mcgillID);
	}
	
	
	
	//---COOP CLASS---//
	//CREATE
	@Transactional
	public Coop createCoop(int coopID, String location, String startDate, String endDate, String semester, String companyName, boolean workPermit, String employerContract, int workLoad, String initialReport, String workExperience, String evaluationReport, String technologies, String coopCourses, String technicalReport, int fkStudentMcgillID) {	
		if (coopID == 0) {
			throw new IllegalArgumentException("ID cannot be empty!");
		}
		if (location == null) {
			throw new IllegalArgumentException("Location cannot be empty!");
		}
		if (startDate == null) {
			throw new IllegalArgumentException("Start Date cannot be empty!");
		}
		if (endDate == null) {
			throw new IllegalArgumentException("End Date cannot be empty!");
		}
		if (semester == null) {
			throw new IllegalArgumentException("Semester cannot be empty!");
		}
		if (companyName == null) {
			throw new IllegalArgumentException("Company Name cannot be empty!");
		}
		if (fkStudentMcgillID == 0) {
			throw new IllegalArgumentException("Foreign key cannot be 0!");
		}
		
		Coop coop = new Coop();
		coop.setCoopID(coopID);
		coop.setLocation(location);
		coop.setStartDate(startDate);
		coop.setEndDate(endDate);
		coop.setSemester(semester);
		coop.setCompanyName(companyName);
		coop.setWorkPermit(workPermit);
		coop.setEmployerContract(employerContract);
		coop.setWorkLoad(workLoad);
		coop.setInitialReport(initialReport);
		coop.setWorkExperience(workExperience);
		coop.setEvaluationReport(evaluationReport);
		coop.setTechnologies(technologies);
		coop.setCoopCourses(coopCourses);
		coop.setTechnicalReport(technicalReport);
		coop.setStudent(studentrepository.findBymcgillID(fkStudentMcgillID));
		cooprepository.save(coop); //saves student into the database
		
		return coop;
	}
	
	//READ
	@Transactional
	public Coop getCoop(int coopID) {
		return cooprepository.findBycoopID(coopID); //returns student with the primary key id
	}
	//RETRIEVE ALL COOPS
	@Transactional
	public List<Coop> getAllCoops() {
		return toList(cooprepository.findAll());
	}
	
	//DELETE
	@Transactional
	public Coop deleteCoop(int coopID) {
		return cooprepository.deleteBycoopID(coopID);
	}
	
 	//Helper method
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
	
}
