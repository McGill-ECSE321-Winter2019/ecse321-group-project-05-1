package ca.mcgill.ecse321.cooperator.dto;

import ca.mcgill.ecse321.cooperator.model.Student;

public class CoopDto {
	private int coopID;
	private String location;
	private String startDate;
	private String endDate;
	private String semester;
	private String companyName;
	private boolean workPermit;
	private String employerContract;
	private int workLoad;
	private String initialReport;
	private String workExperience;
	private String evaluationReport;
	private String technologies;
	private String coopCourses;
	private String technicalReport;
	private int fkStudentMcgillID;
	 
	public CoopDto() {
	}
	
	public CoopDto(int coopID, String location, String startDate, String endDate, String semester, String companyName, boolean workPermit, String employerContract, int workLoad, String initialReport, String workExperience, String evaluationReport, String technologies, String coopCourses, String technicalReport, int fkStudentMcgillID) {
		this.coopID = coopID;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.semester = semester;
		this.companyName = companyName;
		this.workPermit = workPermit;
		this.employerContract = employerContract;
		this.workLoad = workLoad; 
		this.initialReport = initialReport;
		this.workExperience = workExperience;
		this.evaluationReport = evaluationReport;
		this.technologies = technologies;
		this.coopCourses = coopCourses;
		this.technicalReport = technicalReport;
		this.fkStudentMcgillID = fkStudentMcgillID;
	}
	
	public int getCoopId() {
		return coopID;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public String getSemester() {
		return semester;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	
	public boolean getWorkPermit() {
		return workPermit;
	}
	
	public String getEmployerContract() {
		return employerContract;
	}
	
	public int getWorkLoad() {
		return workLoad;
	}
	
	public String getInitialReport() {
		return initialReport;
	}
	
	public String getWorkExperience() {
		return workExperience;
	}
	
	public String getEvaluationReport() {
		return evaluationReport;
	}
	
	public String getTechnologies() {
		return technologies;
	}
	
	public String getCoopCourses() {
		return coopCourses;
	}
	
	public String getTechnicalReport() {
		return technicalReport;
	}
	 
	public int getfkStudentMcgillID() {
		return fkStudentMcgillID;
	}
}
