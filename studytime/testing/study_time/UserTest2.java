package study_time;

import java.util.ArrayList;
import java.util.List;

import project.com.bo.Subjects;
import project.com.dao.SubjectDao;
import project.com.dao.factory.DaoFactory;

public class UserTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
SubjectDao sd = DaoFactory.getSubjectDao();
List<Subjects> list = new ArrayList<Subjects>();
list=sd.getSubject(3);
System.out.println(list.size());
System.out.println(list);
	}

}
