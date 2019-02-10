package ca.mcgill.ecse321.cooperator.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LogIn{
   private String userName;

public void setUserName(String value) {
    this.userName = value;
}
@Id
public String getUserName() {
    return this.userName;
}
private String passWord;

public void setPassWord(String value) {
    this.passWord = value;
}
public String getPassWord() {
    return this.passWord;
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
