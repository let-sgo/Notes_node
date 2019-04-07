package study_time;
import project.com.bo.User;
import project.com.dao.UserDao;
import project.com.dao.factory.DaoFactory;
import project.com.util.EmailSend;


public class UserTest {
public static void main(String args[]){
	UserDao us = DaoFactory.getUserDao();
	String password = us.generatePassword();
	System.out.println(password);
	boolean see1  = us.isRollNoExist(16118901);
	System.out.println(see1);
	boolean see2 = us.userExist(16118901);
	System.out.println(see2);
	//boolean update = us.register(16118967,"ak","verma","tanugauraha172@gmail.com");
	//System.out.println("update "+update);
	//EmailSend es = new EmailSend(password,16118967, "tanugauraha172@gmail.com","ak");
	//boolean bs = es.sendMail();
	//System.out.println(bs);
	boolean see3 = us.isValidUser(16118901,"xyz");
	System.out.println(see3);
	User user=us.getUser(16118901);
	System.out.println(user);
}
}

