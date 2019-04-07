package project.com.bo;

public class Subjects {
int sem_id;
String sub_code;
String subject;
public int getSem_id() {
	return sem_id;
}
public void setSem_id(int sem_id) {
	this.sem_id = sem_id;
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
@Override
public String toString() {
	return "Subjects [sem_id=" + sem_id + ", sub_code=" + sub_code
			+ ", subject=" + subject + "]";
}

}
