package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class InitialReport{
        
	    private int workLoad;

		
	    //workload getter and setter
	    public void setWorkLoad(int value) {
		    this.workLoad = value;
		}
		public int getWorkLoad() {
		    return this.workLoad;
		}
				
		private int initialReportID;
		
		
		//initialReportID getter and setter
		public void setInitialReportID(int value) {
		    this.initialReportID = value;
		}
		@Id
		public int getInitialReportID() {
		    return this.initialReportID;
		}
	   
		
		private Student student;
	   
		
		//RELATIONSHIP WITH STUDENT
		//student getter and setter
	   @OneToOne(optional=false)
	   public Student getStudent() {
	      return this.student;
	   }
	   
	   public void setStudent(Student student) {
	      this.student = student;
	   }
   
   }
