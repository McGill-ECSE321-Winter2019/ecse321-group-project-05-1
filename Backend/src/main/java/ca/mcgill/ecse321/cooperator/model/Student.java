package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student{
private Coop coop;
   
   @OneToOne(mappedBy="student", cascade = CascadeType.ALL)
   public Coop getCoop() {
      return this.coop;
   }
   
   public void setCoop(Coop coop) {
      this.coop = coop;
   }
   
private boolean reportSubmitted;

public void setReportSubmitted(boolean value) {
	this.reportSubmitted = value;
}
public boolean isReportSubmitted() {
	return this.reportSubmitted;
}

private int mcgillID;

public void setMcgillID(int value) {
	    this.mcgillID = value;
	}
@Id
public int getMcgillID() {
	    return this.mcgillID;
	}
	
	
private String name;

public void setName(String value) {
	    this.name = value;
	}
public String getName() {
	    return this.name;
	}
	
	
private String email;

public void setEmail(String value) {
	    this.email = value;
	}
public String getEmail() {
	    return this.email;
	}
	
	
private boolean isEnrolled;

public void setIsEnrolled(boolean value) {
	    this.isEnrolled = value;
	}
public boolean isIsEnrolled() {
	    return this.isEnrolled;
	}
	
	
private int progress;

public void setProgress(int value) {
	    this.progress = value;
	}
public int getProgress() {
	    return this.progress;
	}
}
