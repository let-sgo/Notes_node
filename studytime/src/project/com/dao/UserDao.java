package project.com.dao;

import project.com.bo.User;

public interface UserDao {
String generatePassword();
boolean isRollNoExist(long roll_no);
boolean register(long roll_no,String fname,String lname,String email);
boolean userExist(long roll_no);
boolean isValidUser(long id,String password);
User getUser(long id);
}
