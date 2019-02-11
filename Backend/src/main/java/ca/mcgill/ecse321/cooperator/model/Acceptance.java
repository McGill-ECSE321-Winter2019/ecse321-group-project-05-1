package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Acceptance{
        
		private String location;

		//location getter setter
        public void setLocation(String value) {
		    this.location = value;
		}
		public String getLocation() {
		    return this.location;
		}
		
		
		private int jobID;
		
		
		//jobID getter setter
		public void setJobID(int value) {
		    this.jobID = value;
		}
		
		@Id
		public int getJobID() {
		    return this.jobID;
		}
		
		
		private String date;
		
		
		//date getter setter
		public void setDate(String value) {
		    this.date = value;
		}
		public String getDate() {
		    return this.date;
		}
		
		
		private String semester;
		
		
		//semester getter setter
		public void setSemester(String value) {
		    this.semester = value;
		}
		public String getSemester() {
		    return this.semester;
		}
		
		
		private boolean workPermit;
		
		
		//workPermit getter setter
		public void setWorkPermit(boolean value) {
		    this.workPermit = value;
		}
		public boolean isWorkPermit() {
		    return this.workPermit;
		}
		
		
		private String employer;
		
		
		//employer getter setter
		public void setEmployer(String value) {
		    this.employer = value;
		}
		public String getEmployer() {
		    return this.employer;
		}
	   
		
		private Student student;
	   
		//RELATION WITH STUDENT
		//student getter setter
	   @OneToOne(optional=false)
	   public Student getStudent() {
	      return this.student;
	   }
	   
	   public void setStudent(Student student) {
	      this.student = student;
	   }
   
}
