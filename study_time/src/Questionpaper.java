import java.util.List;

import project.com.bo.QuestionPaper;
import project.com.dao.QuestionPaperDao;
import project.com.dao.factory.DaoFactory;


public class Questionpaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
QuestionPaperDao qp = DaoFactory.getQuestionPaperDao();
List<QuestionPaper>  list = qp.getQuestionPaperField(6,"CT2","IT601");
System.out.println(list);
	}

}
