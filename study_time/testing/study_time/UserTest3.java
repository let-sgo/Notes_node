package study_time;

import project.com.dao.UserDao;
import project.com.dao.factory.DaoFactory;

public class UserTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
UserDao usd = DaoFactory.getUserDao();
boolean r1 =usd.deleteStudentByYear(3);
boolean r2 = usd.enterRollNo(16118001,85,3);
System.out.println(r2);
boolean r3 = usd.enterRollNoSlider(16118901,10,3);
System.out.println(r3);
boolean r4 = usd.updateYear(4,3);
System.out.println(r4);
	}

}
