package project.com.dao;

import java.util.List;

import project.com.bo.Subjects;

public interface SubjectDao {
List<Subjects> getSubject(int sem_id);
}
