package ca.mcgill.ecse321.cooperator.service;

import java.util.List;

import javax.transaction.Transactional;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.cooperator.dao.AcceptanceRepository;
import ca.mcgill.ecse321.cooperator.dao.EmployerContractRepository;
import ca.mcgill.ecse321.cooperator.dao.EvaluationRepository;
import ca.mcgill.ecse321.cooperator.dao.InitialReportRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import ca.mcgill.ecse321.cooperator.model.Acceptance;
import ca.mcgill.ecse321.cooperator.model.EmployerContract;
import ca.mcgill.ecse321.cooperator.model.Evaluation;
import ca.mcgill.ecse321.cooperator.model.InitialReport;
import ca.mcgill.ecse321.cooperator.model.Student;

@Service
public class CooperatorService {
	@Autowired
	StudentRepository studentrepository;
	@Autowired
	AcceptanceRepository acceptancerepository;
	@Autowired
	EvaluationRepository evaluationrepository;
	@Autowired
	InitialReportRepository initialreportrepository;
	@Autowired
	EmployerContractRepository employercontractrepository;
	
	
	//---STUDENT CLASS---//
	//CREATE
	@Transactional
	public Student createStudent(int id, String name, String email, String password) {
		Student student = new Student();
		student.setId(id);
		student.setName(name);
		student.setEmail(email);
		student.setPassword(password);
		student.setProgress(0); //progress initialized to 0 when student object is created
		
		studentrepository.save(student); //saves student into the database
		
		return student;
	}
	//READ
	@Transactional
	public Student getStudent(int id) {
		return studentrepository.findStudentById(id); //returns student with the primary key id
	}
	//RETRIEVE ALL STUDENTS
	@Transactional
	public List<Student> getAllStudents() {
		return toList(studentrepository.findAll());
	}
	
	//DELETE
	@Transactional
	public Student updateStudent(int studentId) {
		return studentrepository.deleteStudentById(studentId);
	}
	
	//---ACCEPTANCE CLASS---//
	//CREATE
	@Transactional
	public Acceptance createAcceptance(String location, int jobId, String date, String semester, String employer, boolean workpermit) {
		Acceptance acceptance =  new Acceptance();
		acceptance.setDate(date);
		acceptance.setEmployer(employer);
		acceptance.setJobID(jobId); //PRIMARY KEY
		acceptance.setLocation(location);
		acceptance.setSemester(semester);
		acceptance.setWorkPermit(workpermit);
		
		acceptancerepository.save(acceptance);
		
		return acceptance;
		
	}
	
	//READ
	@Transactional
	public Acceptance getAcceptance(int jobId) {
		return acceptancerepository.findAcceptanceById(jobId);
	}
	
	//DELETE
	@Transactional
	public Acceptance deleteAcceptance(int jobId) {
		return acceptancerepository.deleteAcceptanceById(jobId);
	}
	
	//---EVALUATION CLASS---//
	//CREATE
	@Transactional
	public Evaluation createEvaluation(String workExperience, String evaluation, String technologies, String coopCourses, int evaluationID) {
		Evaluation eval = new Evaluation();
		
		eval.setCoopCourses(coopCourses);
		eval.setEvaluation(evaluation);
		eval.setEvaluationID(evaluationID); //PRIMARY KEY
		eval.setTechnologies(technologies);
		eval.setWorkExperience(workExperience);
		
		evaluationrepository.save(eval);
		
		return eval;
		
	}
	
	//READ
	@Transactional
	public Evaluation getEvaluation(int evaluationID) {
		return evaluationrepository.findEvaluationById(evaluationID);
	}
	
	//DELETE
	@Transactional
	public Evaluation deleteEvaluation(int evaluationId) {
		return evaluationrepository.deleteEvaluationById(evaluationId);
	}
	
	
	//---INITIAL REPORT CLASS---//
	//CREATE
	@Transactional
	public InitialReport createInitialReport(int workLoad, int InitialReportId) {
		InitialReport initialReport = new InitialReport();
		initialReport.setInitialReportID(InitialReportId); //PRIMARY KEY
		initialReport.setWorkLoad(workLoad);
		
		initialreportrepository.save(initialReport);
		return initialReport;
	}
	
	//READ
	@Transactional
	public InitialReport getInitialReport(int initialReportId) {
		return initialreportrepository.findInitialReportById(initialReportId);
	}
	
	//DELETE
	@Transactional
	public InitialReport deleteInitialReport(int initialReportId) {
		return initialreportrepository.deleteInitialReportById(initialReportId);
	}
	
	
	//---EMPLOYER CONTRACT CLASS ---//
	//CREATE
	@Transactional
	public EmployerContract createEmployerContract(String contract, int employerContractId) {
		EmployerContract employerContract = new EmployerContract();
		employerContract.setContract(contract);
		employerContract.setEmployerContractID(employerContractId);
		
		employercontractrepository.save(employerContract);
		return employerContract;
	}
	
	//READ
	@Transactional
	public EmployerContract getEmployerContract(int EmployerContractId) {
		return employercontractrepository.findEmployerContractById(EmployerContractId);
	}
	
	//DELETE
	@Transactional
	public EmployerContract deleteEmployerContract(int EmployerContractId) {
		return employercontractrepository.deleteEmployerContractById(EmployerContractId);
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
