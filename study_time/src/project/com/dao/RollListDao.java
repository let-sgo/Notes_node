package project.com.dao;

import java.util.List;

import project.com.bo.ROLL_LIST;

public interface RollListDao {
	boolean enterRollNo (long startingrollno,int totalStudent,int year);
	boolean enterRollNoSlider (long startstartingrollno,int totalStudent,int year);
	boolean deleteStudentByYear(int year);
	boolean updateYear(int previousYear,int updatedYear);
	List<ROLL_LIST> getAllRollNo(int year);
}
