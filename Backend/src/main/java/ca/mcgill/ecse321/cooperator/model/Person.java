package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Set;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
public class Person{
   private String name;

public void setName(String value) {
    this.name = value;
}
@Id
public String getName() {
    return this.name;
}
private Set<Tasks> tasks;

@OneToMany(mappedBy="person" )
public Set<Tasks> getTasks() {
   return this.tasks;
}

public void setTasks(Set<Tasks> taskss) {
   this.tasks = taskss;
}

private int id;

public void setId(int value) {
    this.id = value;
}
public int getId() {
    return this.id;
}
private String email;

public void setEmail(String value) {
    this.email = value;
}
public String getEmail() {
    return this.email;
}
   private Set<Student> student;
   
   @OneToMany(mappedBy="person" , cascade={CascadeType.ALL})
   public Set<Student> getStudent() {
      return this.student;
   }
   
   public void setStudent(Set<Student> students) {
      this.student = students;
   }
   
   }
