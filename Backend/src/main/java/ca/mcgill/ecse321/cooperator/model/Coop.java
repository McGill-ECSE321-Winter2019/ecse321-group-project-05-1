package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Coop{
	
	private int coopID;
	public void setCoopID(int value) {
	    this.coopID = value;
	}
	@Id
	public int getCoopID() {
	    return this.coopID;
	}
	
	private String location;
	public void setLocation(String value) {
	    this.location = value;
	}
	public String getLocation() {
	    return this.location;
	}
	
	private String startDate;
	public void setStartDate(String value) {
	    this.startDate = value;
	}
	public String getStartDate() {
	    return this.startDate;
	}
	
	private String semester;
	public void setSemester(String value) {
	    this.semester = value;
	}
	public String getSemester() {
	    return this.semester;
	}
	
	private String companyName;
	public void setCompanyName(String value) {
	    this.companyName = value;
	}
	public String getCompanyName() {
	    return this.companyName;
	}
	
	private boolean workPermit;
	public void setWorkPermit(boolean value) {
	    this.workPermit = value;
	}
	public boolean isWorkPermit() {
	    return this.workPermit;
	}
	
	private String employerContract;
	public void setEmployerContract(String value) {
	    this.employerContract = value;
	}
	public String getEmployerContract() {
	    return this.employerContract;
	}
	
	private int workLoad;
	public void setWorkLoad(int value) {
	    this.workLoad = value;
	}
	public int getWorkLoad() {
	    return this.workLoad;
	}
	
	private String initialReport;
	public void setInitialReport(String value) {
	    this.initialReport = value;
	}
	public String getInitialReport() {
	    return this.initialReport;
	}
	
	private String workExperience;
	public void setWorkExperience(String value) {
	    this.workExperience = value;
	}
	public String getWorkExperience() {
	    return this.workExperience;
	}
	
	private String evaluationReport;
	public void setEvaluationReport(String value) {
	    this.evaluationReport = value;
	}
	public String getEvaluationReport() {
	    return this.evaluationReport;
	}
	
	private String technologies;
	public void setTechnologies(String value) {
	    this.technologies = value;
	}
	public String getTechnologies() {
	    return this.technologies;
	}
	
	private String coopCourses;
	public void setCoopCourses(String value) {
	    this.coopCourses = value;
	}
	public String getCoopCourses() {
	    return this.coopCourses;
	}
	
	private String endDate;
	public void setEndDate(String value) {
	    this.endDate = value;
	}
	public String getEndDate() {
	    return this.endDate;
	}
	
	private String technicalReport;
	public void setTechnicalReport(String value) {
	    this.technicalReport = value;
	}
	public String getTechnicalReport() {
	    return this.technicalReport;
	}
	
	   private Student student;
	   
	   @OneToOne(optional=false)
	   public Student getStudent() {
	      return this.student;
	   }
	   
	   public void setStudent(Student student) {
	      this.student = student;
	   }
   
   }
