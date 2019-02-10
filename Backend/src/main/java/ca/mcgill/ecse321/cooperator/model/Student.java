package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student{
   private int id;

public void setId(int value) {
    this.id = value;
}
@Id
public int getId() {
    return this.id;
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
private String password;

public void setPassword(String value) {
    this.password = value;
}
public String getPassword() {
    return this.password;
}
private int progress;

public void setProgress(int value) {
    this.progress = value;
}
public int getProgress() {
    return this.progress;
}
   private Acceptance acceptance;
   
   @OneToOne(mappedBy="student" , optional=false)
   public Acceptance getAcceptance() {
      return this.acceptance;
   }
   
   public void setAcceptance(Acceptance acceptance) {
      this.acceptance = acceptance;
   }
   
   private InitialReport initialReport;
   
   @OneToOne(mappedBy="student" , optional=false)
   public InitialReport getInitialReport() {
      return this.initialReport;
   }
   
   public void setInitialReport(InitialReport initialReport) {
      this.initialReport = initialReport;
   }
   
   private EmployerContract employerContract;
   
   @OneToOne(mappedBy="student" , optional=false)
   public EmployerContract getEmployerContract() {
      return this.employerContract;
   }
   
   public void setEmployerContract(EmployerContract employerContract) {
      this.employerContract = employerContract;
   }
   
   private Evaluation evaluation;
   
   @OneToOne(mappedBy="student" , optional=false)
   public Evaluation getEvaluation() {
      return this.evaluation;
   }
   
   public void setEvaluation(Evaluation evaluation) {
      this.evaluation = evaluation;
   }
   
   }
