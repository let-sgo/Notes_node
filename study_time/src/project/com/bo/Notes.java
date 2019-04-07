package project.com.bo;

public class Notes {
long sno;
long id;
int sem_id;
String subcode;
String subject;
String file_name;
public long getSno() {
	return sno;
}
public void setSno(long sno) {
	this.sno = sno;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public int getSem_id() {
	return sem_id;
}
public void setSem_id(int sem_id) {
	this.sem_id = sem_id;
}
public String getSubcode() {
	return subcode;
}
public void setSubcode(String subcode) {
	this.subcode = subcode;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getFile_name() {
	return file_name;
}
public void setFile_name(String file_name) {
	this.file_name = file_name;
}
@Override
public String toString() {
	return "Notes [sno=" + sno + ", id=" + id + ", sem_id=" + sem_id
			+ ", subcode=" + subcode + ", subject=" + subject + ", file_name="
			+ file_name + "]";
}

}
