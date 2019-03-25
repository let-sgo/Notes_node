package project.com.dao.factory;

import project.com.dao.NotesDao;
import project.com.dao.SubjectDao;
import project.com.dao.UserDao;
import project.com.dao.impl.NotesDaoOracle;
import project.com.dao.impl.SubjectDaoOracle;
import project.com.dao.impl.UserDaoOracle;

public final class DaoFactory {
	private DaoFactory() {}
	
	private static UserDao usdao = null;
	private static SubjectDao sdao = null;
	private static NotesDao ndao = null;

	
	public static UserDao getUserDao() {
		 if(usdao==null) {
			 usdao =new UserDaoOracle();
		 }
	 return usdao;
	}
	public static SubjectDao getSubjectDao() {
		 if(sdao==null) {
			 sdao =new SubjectDaoOracle();
		 }
	 return sdao;
	}
	public static NotesDao getNotesDao() {
		 if(ndao==null) {
			 ndao =new NotesDaoOracle();
		 }
	 return ndao;
	}
}
