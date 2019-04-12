import java.util.List;

import project.com.bo.Notes;
import project.com.dao.NotesDao;
import project.com.dao.factory.DaoFactory;


public class NotesTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
NotesDao nd = DaoFactory.getNotesDao();
List<Notes> list =nd.getNotesBySubject("IT601",6);
System.out.println(list);
	}

}
