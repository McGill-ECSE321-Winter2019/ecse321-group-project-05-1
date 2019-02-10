package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class EmployerContract{
   private String contract;

public void setContract(String value) {
    this.contract = value;
}
public String getContract() {
    return this.contract;
}
private int employerContractID;

public void setEmployerContractID(int value) {
    this.employerContractID = value;
}
@Id
public int getEmployerContractID() {
    return this.employerContractID;
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
