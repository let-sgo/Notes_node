package project.com.dao;

import java.util.List;

import project.com.bo.Notes;

public interface NotesDao {
boolean delete(long sno);
List<Notes> getNotesBySubject(String subcode,long semid);
}
