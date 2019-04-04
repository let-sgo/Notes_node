//package project.com.dao;

import java.util.List;

//import project.com.bo.QuestionPaper;

public interface QuestionPaperDao {
// whether write or not methods of interface  is always public abstract
	List<QuestionPaper> getQuestionPaperField(int sem_id,String  domain_name,String  sub_code);
}
