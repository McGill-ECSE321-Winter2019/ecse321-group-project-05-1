package ca.mcgill.ecse321.cooperator.controller;

import ca.mcgill.ecse321.cooperator.service.CooperatorService;

import ca.mcgill.ecse321.cooperator.dto.StudentDto;
import ca.mcgill.ecse321.cooperator.model.Student;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.cooperator.dto.CoopDto;
import ca.mcgill.ecse321.cooperator.model.Coop;

@CrossOrigin(origins = "*")
@RestController
public class CooperatorRestController {
	
	private CooperatorService service;
	
	//Post request to create a student object
	@PostMapping(value = { "/students/{id}", "/students/{id}/" })
	public StudentDto createStudent(@PathVariable("mcgillID") int mcgillID, 
			@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("progress") int progress, @RequestParam("isEnrolled") boolean isEnrolled,
			@RequestParam("reportSubmitted") boolean reportSubmitted) throws IllegalArgumentException {
		// @formatter:on
		Student student = service.createStudent(mcgillID, name, email, progress, isEnrolled, reportSubmitted);
		return convertToDto(student);
	}
	
	
	@PostMapping(value = { "/students/{coopID}", "/students/{coopID}/" })
	public CoopDto createCoop(@PathVariable("coopID") int coopID, @RequestParam("location") String location,
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
