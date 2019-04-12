package project.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Notes;
import project.com.bo.QuestionPaper;
import project.com.dao.NotesDao;
import project.com.util.DbConnectionUtil;

public class NotesDaoOracle implements NotesDao{

	@Override
	public boolean delete(long sno) {
		Connection con = null;
		PreparedStatement pstmt = null;
        boolean isDeleted = false;
        
        try {
			con = DbConnectionUtil.getConnection();
			String sql = "delete from notes where sno=?";
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setLong(1, sno);
						
			
			if(pstmt.executeUpdate()>0)
				isDeleted = true;

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return isDeleted;
		
	}

	@Override
	public List<Notes> getNotesBySubject(String subcode,long semid) {
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		List<Notes>list=new ArrayList<Notes>();
		try{
		con=DbConnectionUtil.getConnection();
         String sql1="select * from  notes where SUB_CODE=? and SEM_ID =?";	
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,subcode);	
			pstmt.setLong(2,semid);		
	
			rs=pstmt.executeQuery();
			
			while(rs.next()){
          long sno = rs.getLong(1);
          long id  = rs.getLong(2);
          int sem_id = rs.getInt(3);
          String sub_code
          = rs.getString(4);
          String subject = rs.getString(5);
          String filename = rs.getString(6);
          
          Notes notes = new Notes();
          notes.setSno(sno);
          notes.setId(id);
          notes.setSem_id(sem_id);
          notes.setSubcode(sub_code);
          notes.setSubject(subject);
          notes.setFile_name(filename);
         list.add(notes);
			}
		}catch(Exception e){
		 System.out.println(e.getMessage());
	 }finally{
			try{
				DbConnectionUtil.closeConnection(con);
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			
			
		}
		return list;
	}

}
