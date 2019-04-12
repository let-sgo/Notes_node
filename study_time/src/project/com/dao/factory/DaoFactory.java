package project.com.dao.factory;

import project.com.dao.NotesDao;
import project.com.dao.QuestionPaperDao;
import project.com.dao.RollListDao;
import project.com.dao.SubjectDao;
import project.com.dao.UserDao;
import project.com.dao.impl.NotesDaoOracle;
import project.com.dao.impl.QuestionPaperDaoOracle;
import project.com.dao.impl.RollListDaoOracle;
import project.com.dao.impl.SubjectDaoOracle;
import project.com.dao.impl.UserDaoOracle;

public final class DaoFactory {
	private DaoFactory() {}
	
	private static UserDao usdao = null;
	private static SubjectDao sdao = null;
	private static NotesDao ndao = null;
	private static QuestionPaperDao qpaperdao = null;
	private static 	RollListDao rld= null;

	public static QuestionPaperDao getQuestionPaperDao() {
		 if( qpaperdao==null) {
			 //parent interface can hold child reference
			  qpaperdao =new QuestionPaperDaoOracle();
		 }
	 return  qpaperdao;	
   }
	public static RollListDao getRollListDao() {
		 if( rld==null) {
			 //parent interface can hold child reference
			 rld =new RollListDaoOracle();
		 }
	 return  rld;	
  }
	
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
