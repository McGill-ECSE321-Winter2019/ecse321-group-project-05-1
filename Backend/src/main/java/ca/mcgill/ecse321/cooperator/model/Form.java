package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Entity
public class Form{
   private Tasks tasks;
   
   @OneToOne(optional=false)
   public Tasks getTasks() {
      return this.tasks;
   }
   
   public void setTasks(Tasks tasks) {
      this.tasks = tasks;
   }
   
   private boolean verify;

public void setVerify(boolean value) {
    this.verify = value;
}
@Id
public boolean isVerify() {
    return this.verify;
}
   private Set<LogIn> logIn;
   
   @OneToMany(mappedBy="form" , cascade={CascadeType.ALL})
   public Set<LogIn> getLogIn() {
      return this.logIn;
   }
   
   public void setLogIn(Set<LogIn> logIns) {
      this.logIn = logIns;
   }
   
   private Set<InitialReport> initialReport;
   
   @OneToMany(mappedBy="form" , cascade={CascadeType.ALL})
   public Set<InitialReport> getInitialReport() {
      return this.initialReport;
   }
   
   public void setInitialReport(Set<InitialReport> initialReports) {
      this.initialReport = initialReports;
   }
   
   private Set<Acceptance> acceptance;
   
   @OneToMany(mappedBy="form" , cascade={CascadeType.ALL})
   public Set<Acceptance> getAcceptance() {
      return this.acceptance;
   }
   
   public void setAcceptance(Set<Acceptance> acceptances) {
      this.acceptance = acceptances;
   }
   
   private Set<EmployerContract> employerContract;
   
   @OneToMany(mappedBy="form" , cascade={CascadeType.ALL})
   public Set<EmployerContract> getEmployerContract() {
      return this.employerContract;
   }
   
   public void setEmployerContract(Set<EmployerContract> employerContracts) {
      this.employerContract = employerContracts;
   }
   
   private Set<Evaluation> evaluation;
   
   @OneToMany(mappedBy="form" , cascade={CascadeType.ALL})
   public Set<Evaluation> getEvaluation() {
      return this.evaluation;
   }
   
   public void setEvaluation(Set<Evaluation> evaluations) {
      this.evaluation = evaluations;
   }
   
   }
