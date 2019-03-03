package ca.mcgill.ecse321.cooperator.controller;

import ca.mcgill.ecse321.cooperator.service.CooperatorService;

import ca.mcgill.ecse321.cooperator.dto.StudentDto;
import ca.mcgill.ecse321.cooperator.model.Student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.CoopDto;
import ca.mcgill.ecse321.cooperator.model.Coop;

@CrossOrigin(origins = "*")
@RestController
public class CooperatorRestController {
	
	private CooperatorService service;
	
	//Post request to create a student object
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
	@PostMapping(value = { "/students/{mcgillID}/{coopID}", "/students/{mcgillID}/{coopID}/" })
	public CoopDto createCoop(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("location") String location,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("semester") String semester, @RequestParam("companyName") String companyName,
			@RequestParam("workPermit") boolean workPermit, @RequestParam("employerContract") String employerContract,
			@RequestParam("workLoad") int workLoad, @RequestParam("initialReport") String initialReport,
			@RequestParam("workExperience") String workExperience, @RequestParam("evaluationReport") String evaluationReport,
			@RequestParam("technologies") String technologies, @RequestParam("coopCourses") String coopCourses,
			@RequestParam("technicalReport") String technicalReport, @	RequestParam("student") Student s) throws IllegalArgumentException {
			
			Coop coop = service.createCoop(coopID, location, startDate, endDate, semester, companyName, workPermit, employerContract, workLoad, initialReport, workExperience, evaluationReport, technologies, coopCourses, technicalReport, s);
			return convertToDto(coop);
	}
	
	//GET: retrieve a particular student's general info
	@GetMapping(value = {"/students1/{mcgillID}", "/students1/{mcgillID}/"})
	public StudentDto getStudent(@PathVariable("mcgillID") int mcgillID) {
		Student student = service.getStudent(mcgillID);
		
		if (student == null) {
			throw new IllegalArgumentException("There is no student associated with that id!");
		}
		
		return convertToDto(student);
	}
	
	//GET: retrieve coop info of a particular student
	@GetMapping(value = {"/students/{mcgillID}/{coopID}", "/students/{mcgillID}/{coopID}/"})
	public CoopDto getCoop(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID) {
		Coop coop = service.getCoop(coopID);
		
		if (coop == null) {
			throw new IllegalArgumentException("There is no Coop associated with that id!");
		}
		return convertToDto(coop);
	}
	
	//PUT: submit initial report of a particular student within first two weeks
	//We take the entire report as an input string
	@PutMapping(value = { "/students/{mcgillID}/{coopID}/initialReport", "/students/{mcgillID}/{coopID}/initialReport/" })
	public void submitInitialReport(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("initialReport") String initialReport) {
		Coop coop = service.getCoop(coopID);
		coop.setInitialReport(initialReport);
		coop.getStudent().setProgress(50);
	}
	
	//PUT: submit technical report during the coop
	//We take the entire report as an input string
	@PutMapping(value = { "/students/{mcgillID}/{coopID}/technicalReport", "/students/{mcgillID}/{coopID}/technicalReport/" })
	public void submitTechnicalReport(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("initialReport") String technicalReport) {
		Coop coop = service.getCoop(coopID);
		coop.setTechnicalReport(technicalReport);
		coop.getStudent().setProgress(75);
	}
	
	//PUT: submit evaluation report at the end of coop
	//We take the entire report as an input string
	@PutMapping(value = { "/students/{mcgillID}/{coopID}/evaluationReport", "/students/{mcgillID}/{coopID}/evaluationReport/" })
	public void submitEvaluationReport(@PathVariable("mcgillID") int mcgillID, @PathVariable("coopID") int coopID, @RequestParam("initialReport") String evaluationReport) {
		Coop coop = service.getCoop(coopID);
		coop.setEvaluationReport(evaluationReport);
		coop.getStudent().setProgress(100);
	}
	
	//GET: check student progress
	@GetMapping(value = {"/students/{mcgillID}", "/students/{mcgillID}/"})
	public int getProgress(@PathVariable("mcgillID") int mcgillID) {
		Student student = service.getStudent(mcgillID);
		return student.getProgress();
	}
	
	//GET: return all students
	@GetMapping(value = { "/students", "/students/" })
	public List<StudentDto> getAllStudents() {
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : service.getAllStudents()) {
			studentDtos.add(convertToDto(student));
		}
		return studentDtos;
	}
	
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
		CoopDto coopDto = new CoopDto(c.getCoopID(), c.getLocation(), c.getStartDate(), c.getEndDate(), c.getSemester(), c.getCompanyName(), c.isWorkPermit(), c.getEmployerContract(), c.getWorkLoad(), c.getInitialReport(), c.getWorkExperience(), c.getEvaluationReport(), c.getTechnologies(), c.getCoopCourses(), c.getTechnicalReport(), c.getStudent());
		return coopDto;
	}
}
