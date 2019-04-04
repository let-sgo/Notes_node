import java.util.*;
public class Testing{
	public static void main(String args[]){
		
		QuestionPaperDao qpo=DaoFactory.getQuestionPaperDao();
		List<QuestionPaper> res= qpo.getQuestionPaperField(6,"CT1","IT601") ;
		System.out.println("res="+res);
		
			/*SubjectDao sd=DaoFactory.getSubjectDao();
			 List<Subjects>res= sd.getSubject(6);
		System.out.println("res="+res);*/
	}
}