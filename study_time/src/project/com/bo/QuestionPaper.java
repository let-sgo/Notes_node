package project.com.bo;

public class QuestionPaper {
	
	int  id;                                               
	 int sem_id  ;                                
	String  domain_name ;                             
	String  sub_code ;                             
	String subject;                                          
	 String year1 ;                                   
	String  filename ;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getSem_id() {
		return sem_id;
	}
	
	public void setSem_id(int sem_id) {
		this.sem_id = sem_id;
	}
	
	public String getDomain_name() {
		return domain_name;
	}
	
	public void setDomain_name(String domain_name) {
		this.domain_name = domain_name;
	}
	
	public String getSub_code() {
		return sub_code;
	}
	
	public void setSub_code(String sub_code) {
		this.sub_code = sub_code;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getYear1() {
		return year1;
	}
	
	public void setYear1(String year1) {
		this.year1 = year1;
	}

	public String getFilename() {
		return filename;
	}
	
	public void setFilename(String filename) {
		this.filename = filename;
	}                                         
	                
@Override
public String toString() {
	return "Subjects [ id= "+ id +", sem_id=" + sem_id + ", sub_code=" + sub_code
			+ ",domain_name= "+ domain_name + ",year= "+ year1 +",filename= "+filename+", subject=" + subject + "]\n";
}

}
