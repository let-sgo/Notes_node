package project.com.dao;

import project.com.bo.User;

public interface UserDao {
String generatePassword();
boolean isRollNoExist(long roll_no);
boolean register(long roll_no,String fname,String lname,String email);
boolean userExist(long roll_no);
boolean isValidUser(long id,String password);
User getUser(long id);
boolean enterRollNo (long start,int totalStudent,int year);
boolean enterRollNoSlider (long start,int totalStudent,int year);
boolean deleteStudentByYear(int year);
boolean updateYear(int previousYear,int updatedYear);
}
