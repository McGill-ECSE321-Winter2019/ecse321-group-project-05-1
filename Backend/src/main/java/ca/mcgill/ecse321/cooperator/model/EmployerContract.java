package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EmployerContract{
   private String contract;

public void setContract(String value) {
    this.contract = value;
}
@Id
public String getContract() {
    return this.contract;
}
   private Form form;
   
   @ManyToOne(optional=false)
   public Form getForm() {
      return this.form;
   }
   
   public void setForm(Form form) {
      this.form = form;
   }
   
   }
