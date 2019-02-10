package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.Id;

@Entity
public class Tasks{
   private Form form;
   
   @OneToOne(mappedBy="tasks" , optional=false)
   public Form getForm() {
      return this.form;
   }
   
   public void setForm(Form form) {
      this.form = form;
   }
   
   private Person person;
   
   @ManyToOne(optional=false)
   public Person getPerson() {
      return this.person;
   }
   
   public void setPerson(Person person) {
      this.person = person;
   }
   
   private boolean taskDone;

public void setTaskDone(boolean value) {
    this.taskDone = value;
}
@Id
public boolean isTaskDone() {
    return this.taskDone;
}
}
