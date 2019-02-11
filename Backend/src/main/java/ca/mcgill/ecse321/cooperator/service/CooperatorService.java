package ca.mcgill.ecse321.cooperator.service;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.mcgill.ecse321.cooperator.dao.AcceptanceRepository;
import ca.mcgill.ecse321.cooperator.dao.EvaluationRepository;
import ca.mcgill.ecse321.cooperator.dao.StudentRepository;
import ca.mcgill.ecse321.cooperator.model.Acceptance;
import ca.mcgill.ecse321.cooperator.model.Evaluation;
import ca.mcgill.ecse321.cooperator.model.Student;

@Service
public class CooperatorService {
	@Autowired
	StudentRepository studentrepository;
	@Autowired
	AcceptanceRepository acceptancerepository;
	@Autowired
	EvaluationRepository evaluationrepository;
	
	
	//STUDENT CLASS
	//CREATE
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
	public Student getStudent(int id) {
		return studentrepository.findStudentById(id); //returns student with the primary key id
	}
	//RETRIEVE ALL STUDENTS
	public List<Student> getAllStudents() {
		return toList(studentrepository.findAll());
	}
	
	//ACCEPTANCE CLASS
	//CREATE
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
	public Acceptance getAcceptance(int jobId) {
		return acceptancerepository.findAcceptanceById(jobId);
	}
	
	//EVALUATION CLASS
	//CREATE
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
	public Evaluation getEvaluation(int evaluationID) {
		return evaluationrepository.findEvaluationById(evaluationID);
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
