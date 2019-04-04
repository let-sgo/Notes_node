//package project.com.dao.factory;
public final class DaoFactory {
	private DaoFactory() {}
	
	private static QuestionPaperDao qpaperdao = null;
	private static SubjectDao sdao = null;
	
	public static QuestionPaperDao getQuestionPaperDao() {
		 if( qpaperdao==null) {
			 //parent interface can hold child reference
			  qpaperdao =new QuestionPaperDaoOracle();
		 }
	 return  qpaperdao;	
    }


  public static SubjectDao getSubjectDao() {
		 if(sdao==null) {
			 sdao =new SubjectDaoOracle();
		 }
	 return sdao;
	}
}
