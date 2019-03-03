package ca.mcgill.ecse321.cooperator.dto;

public class StudentDto {
	private int mcgillID;
	private String name;
	private String email;
	private boolean reportSubmitted;
	private boolean isEnrolled;
	private int progress;
	
	public StudentDto() {
	}
	
	public StudentDto(int mcgillID, String name, String email, boolean reportSubmitted, boolean isEnrolled, int progress) {
		this.mcgillID = mcgillID;
		this.name = name;
		this.email = email;
		this.reportSubmitted = reportSubmitted;
		this.isEnrolled = isEnrolled;
		this.progress = progress;
	}
	
	public int getMcgillID() {
		return mcgillID;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public boolean getReportSubmitted() {
		return reportSubmitted;
	}
	
	public boolean getIsEnrolled() {
		return isEnrolled;
	}
	
	public int getProgress() {
		return progress;
	}
}
