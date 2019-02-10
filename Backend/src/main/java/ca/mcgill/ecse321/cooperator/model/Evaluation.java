package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Evaluation{
   private String workExperience;

public void setWorkExperience(String value) {
    this.workExperience = value;
}
public String getWorkExperience() {
    return this.workExperience;
}
private String evaluation;

public void setEvaluation(String value) {
    this.evaluation = value;
}
public String getEvaluation() {
    return this.evaluation;
}
private String technologies;

public void setTechnologies(String value) {
    this.technologies = value;
}
public String getTechnologies() {
    return this.technologies;
}
private String coopCourses;

public void setCoopCourses(String value) {
    this.coopCourses = value;
}
public String getCoopCourses() {
    return this.coopCourses;
}
private int evaluationID;

public void setEvaluationID(int value) {
    this.evaluationID = value;
}
@Id
public int getEvaluationID() {
    return this.evaluationID;
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
