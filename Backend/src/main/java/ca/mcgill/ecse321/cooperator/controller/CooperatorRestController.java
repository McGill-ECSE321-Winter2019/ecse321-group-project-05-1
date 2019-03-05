package ca.mcgill.ecse321.cooperator.controller;

import ca.mcgill.ecse321.cooperator.service.CooperatorService;

import ca.mcgill.ecse321.cooperator.dto.StudentDto;
import ca.mcgill.ecse321.cooperator.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.CoopDto;
import ca.mcgill.ecse321.cooperator.model.Coop;

@CrossOrigin(origins = "*")
@RestController
public class CooperatorRestController {
	
	@Autowired
	private CooperatorService service;
	
	// =================================================================================================================
	//
	//							REST METHODS FOR STUDENT
	//
	// =================================================================================================================
	
	//Post request to create a student object
	/*
	 * http://localhost:8080/students?mcgillID=123&name=archit&email=archit@mail.mcgill.ca&progress=56&isEnrolled=true&reportSubmitted=false
	 */
	@PostMapping(value = { "/students", "/students/" })
	public StudentDto createStudent(@RequestParam("mcgillID") int mcgillID, 
			@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("progress") int progress, @RequestParam("isEnrolled") boolean isEnrolled,
			@RequestParam("reportSubmitted") boolean reportSubmitted) throws IllegalArgumentException {
		// @formatter:on
		Student student = service.createStudent(mcgillID, name, email, progress, isEnrolled, reportSubmitted);
		return convertToDto(student);
	}
	
	//Post request to create a Coop object
	/*
	 * http://localhost:8080/coops?coopID=98765&location=Montreal&startDate=01052019&endDate=31082019&semester=fall&companyName=ElementAI&workPermit=false&employerContract=googleLink&workLoad=2&initialReport=googleLink2&workExperience=good&evaluationReport=googleLink3&technologies=SpringBoot&coopCourses=ecse321&technicalReport=googleLink4&fkStudentMcgillID=12345
	 */
	@PostMapping(value = { "/coops", "/coops/" })
	public CoopDto createCoop(@RequestParam("coopID") int coopID, @RequestParam("location") String location,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("semester") String semester, @RequestParam("companyName") String companyName,
			@RequestParam("workPermit") boolean workPermit, @RequestParam("employerContract") String employerContract,
			@RequestParam("workLoad") int workLoad, @RequestParam("initialReport") String initialReport,
			@RequestParam("workExperience") String workExperience, @RequestParam("evaluationReport") String evaluationReport,
			@RequestParam("technologies") String technologies, @RequestParam("coopCourses") String coopCourses,
			@RequestParam("technicalReport") String technicalReport, @RequestParam("fkStudentMcgillID") int fkStudentMcgillID) throws IllegalArgumentException {
			
			Coop coop = service.createCoop(coopID, location, startDate, endDate, semester, companyName, workPermit, employerContract, workLoad, initialReport, workExperience, evaluationReport, technologies, coopCourses, technicalReport, fkStudentMcgillID);
			return convertToDto(coop);
	}
	
	//GET: retrieve a particular student's general info
	/*
	 * http://localhost:8080/studentsAll/123
	 */
	@GetMapping(value = {"/studentsAll/{mcgillID}", "/studentsAll/{mcgillID}/"})
	public StudentDto getStudent(@PathVariable("mcgillID") int mcgillID) {
		Student student = service.getStudent(mcgillID);
		
		if (student == null) {
			throw new IllegalArgumentException("There is no student associated with that id!");
		}
		
		return convertToDto(student);
	}
	
	//GET: retrieve coop info of a particular student
	/*
	 * http://localhost:8080/students/123/98765
	 */
	@GetMapping(value = {"/students/{mcgillID}/{coopID}", "/students/{mcgillID}/{coopID}/"})
	public CoopDto getCoop(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID) {
		Coop coop = service.getCoop(coopID);
		
		if (coop == null) {
			throw new IllegalArgumentException("There is no Coop associated with that id!");
		} 
		return convertToDto(coop);
	}
	
	//PUT: submit initial report of a particular student within first two weeks
	/*
	 * http://localhost:8080/students/123/98765/initialReport?initialReport=googleLink1
	 */
	@PutMapping(value = { "/students/{mcgillID}/{coopID}/initialReport", "/students/{mcgillID}/{coopID}/initialReport/" })
	public void submitInitialReport(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("initialReport") String initialReport) {
		Coop coop = service.getCoop(coopID);
		coop.setInitialReport(initialReport);
		coop.getStudent().setProgress(50);
	}
	
	//PUT: submit technical report during the coop
	/*
	 * http://localhost:8080/students/123/98765?technicalReport=googleLink2
	 */
	@PutMapping(value = { "/students/{mcgillID}/{coopID}/technicalReport", "/students/{mcgillID}/{coopID}/technicalReport/" })
	public void submitTechnicalReport(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("initialReport") String technicalReport) {
		Coop coop = service.getCoop(coopID);
		coop.setTechnicalReport(technicalReport);
		coop.getStudent().setProgress(75);
	}
	
	//PUT: submit evaluation report at the end of coop
	/*
	 * http://localhost:8080/students/123/98765?evaluationReport=googleLink3
	 */
	@PutMapping(value = { "/students/{mcgillID}/{coopID}/evaluationReport", "/students/{mcgillID}/{coopID}/evaluationReport/" })
	public void submitEvaluationReport(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("initialReport") String evaluationReport) {
		Coop coop = service.getCoop(coopID);
		coop.setEvaluationReport(evaluationReport);
		coop.getStudent().setProgress(100);
	}
	
	//GET: check student progress
	/*
	 * http://localhost:8080/students/123
	 */
	@GetMapping(value = {"/students/{mcgillID}", "/students/{mcgillID}/"})
	public int getProgress(@PathVariable("mcgillID") int mcgillID) {
		Student student = service.getStudent(mcgillID);
		return student.getProgress();
	}
	
	// =================================================================================================================
	//
	//									REST METHODS FOR CO-OP ADMIN
	//
	// =================================================================================================================
	
	//GET: return all students
	/*
	 * http://localhost:8080/students
	 */
	@GetMapping(value = { "/students", "/students/" })
	public List<StudentDto> getAllStudents() {
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : service.getAllStudents()) {
			studentDtos.add(convertToDto(student));
		}
		return studentDtos;
	}
	
	//GET: return all coops
	/*
	 * http://localhost:8080/coops
	 */
	@GetMapping(value = {"/coops", "/coops/" })
	public List<CoopDto> getAllCoop() {
		List<CoopDto> coopDtos = new ArrayList<>();
		for (Coop coop : service.getAllCoops()) {
			coopDtos.add(convertToDto(coop));
		}
		return coopDtos;
	}
	
	//PUT: Edit student enrollment
	/*
	 * http://localhost:8080/students/123/editEnrolment?isEnrolled=true
	 */
	@PutMapping(value = {"/students/{studentMcgillID}/editEnrolment", "/students/{studentMcgillID}/editEnrolment/"})
	public StudentDto editStudentEnrolment(@PathVariable("studentMcgillID") int studentMcgillID, @RequestParam("isEnrolled") boolean isEnrolled) {
		Student student = service.getStudent(studentMcgillID);
		student.setIsEnrolled(isEnrolled);
		return convertToDto(student);
	}
	
	//PUT: Change student's WorkPermit status
	/*
	 * http://localhost:8080/coops/987/editWorkPermit?hasWorkPermit=true
	 */
	@PutMapping(value = {"/coops/{coopID}/editWorkPermit", "/coops/{coopID}/editWorkPermit/"})
	public CoopDto editStudentWorkPermit(@PathVariable("coopID") int coopID, @RequestParam("hasWorkPermit") boolean hasWorkPermit) {
		Coop coop = service.getCoop(coopID);
		coop.setWorkPermit(hasWorkPermit);
		return convertToDto(coop);
	}
	
	//PUT: Edit coop courses
	/*
	 * http://localhost:8080/coops/987/editCoopCourses?coopCourses=comp251
	 */
	@PutMapping(value = {"/coops/{coopID}/editCoopCourses", "/coops/{coopID}/editCoopCourses/"})
	public CoopDto editCoopCourses(@PathVariable("coopID") int coopID, @RequestParam("coopCourses") String coopCourses) {
		Coop coop = service.getCoop(coopID);
		coop.setCoopCourses(coopCourses);
		return convertToDto(coop);
	}
	
	//PUT: Edit coop semester
	/*
	 * http://localhost:8080/coops/987/editCoopSemester?semester=winter
	 */
	@PutMapping(value = {"/coops/{coopID}/editCoopSemester", "/coops/{coopID}/editCoopSemester/"})
	public CoopDto editCoopSemester(@PathVariable("coopID") int coopID, @RequestParam("semester") String semester) {
		Coop coop = service.getCoop(coopID);
		coop.setSemester(semester);
		return convertToDto(coop);
	}
	
	//PUT: Edit startDate and endDate
	/*
	 * http://localhost:8080/coops/987/editDates?startDate=01012020&endDate=30042020
	 */
	@PutMapping(value = {"/coops/{coopID}/editDates", "/coops/{coopID}/editDates/"})
	public CoopDto editDates(@PathVariable("coopID") int coopID, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
		Coop coop = service.getCoop(coopID);
		coop.setStartDate(startDate);
		coop.setEndDate(endDate);
		return convertToDto(coop);
	}
	
	//DELETE: delete a student
	/*
	 * http://localhost:8080/students?studentMcgillID=123
	 */
	@DeleteMapping(value = {"/students", "/students/"})
	public void deleteStudent(@RequestParam("studentMcgillID") int studentMcgillID) {
		service.deleteStudent(studentMcgillID);
	}
	
	//DELETE: delete a coop associated with a student.
	/*
	 * https://localhost:8080/coops?coopID=987
	 */
	@DeleteMapping(value = {"/coops", "/coops/"})
	public void deleteCoop(@RequestParam("coopID") int coopID) {
		service.deleteCoop(coopID);
	}
	
	// =================================================================================================================
	//
	//									HELPER STUDENT METHODS
	//
	// =================================================================================================================
	
	private StudentDto convertToDto(Student s) {
		if (s == null) {
			throw new IllegalArgumentException("There is no such student!");
		}
		StudentDto studentDto = new StudentDto(s.getMcgillID(), s.getName(), s.getEmail(), s.isReportSubmitted(), s.isIsEnrolled(), s.getProgress());
		//studentDto.setEvents(createEventDtosForPerson(p));
		return studentDto;
	}
	 
	private CoopDto convertToDto(Coop c) {
		if (c == null) {
			throw new IllegalArgumentException("There is no such Coop!");
		}
		CoopDto coopDto = new CoopDto(c.getCoopID(), c.getLocation(), c.getStartDate(), c.getEndDate(), c.getSemester(), c.getCompanyName(), c.isWorkPermit(), c.getEmployerContract(), c.getWorkLoad(), c.getInitialReport(), c.getWorkExperience(), c.getEvaluationReport(), c.getTechnologies(), c.getCoopCourses(), c.getTechnicalReport(), c.getStudent().getMcgillID());
		return coopDto;
	}
}
