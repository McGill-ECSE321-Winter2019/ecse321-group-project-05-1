package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class InitialReport{
   private String tasks;

public void setTasks(String value) {
    this.tasks = value;
}
@Id
public String getTasks() {
    return this.tasks;
}
private int workLoad;

public void setWorkLoad(int value) {
    this.workLoad = value;
}
public int getWorkLoad() {
    return this.workLoad;
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
