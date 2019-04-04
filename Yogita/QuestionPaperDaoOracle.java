/*package project.com.dao.impl;

import java.util.List;

import project.com.bo.QuestionPaper;
import project.com.dao.QuestionPaperDao;*/
import java.util.*;
import java.sql.*;

public class QuestionPaperDaoOracle implements QuestionPaperDao {

	@Override
	public List<QuestionPaper> getQuestionPaperField(int sem_id,String domain_name,String  sub_code) {
		// TODO Auto-generated method stub
		DbConnectionUtil dbcon=new DbConnectionUtil();
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		List<QuestionPaper>list=new ArrayList<QuestionPaper>();
		try{
		con=dbcon.getConnection();
         String sql1="select * from  QUETIONPAPER where  DOMAIN_NAME=? and SUB_CODE=? and SEM_ID =?";	
			pstmt=con.prepareStatement(sql1);
			pstmt.setString(1,domain_name);		 
			pstmt.setString(2,sub_code);		 
			pstmt.setInt(3,sem_id);		 
			rs=pstmt.executeQuery();
			 java.text.SimpleDateFormat sdf = new  java.text.SimpleDateFormat();
	         sdf.applyPattern("yyyy");
			while(rs.next()){
           int id=rs.getInt("id");				
			String subject=rs.getString("SUBJECT");;                                          
			java.sql.Date year1=rs.getDate("YEAR1") ;
			//String year1=rs.getDate("YEAR1") ;    
			String filename=rs.getString("FILENAME");
			//System.out.println("filename="+filename);
			QuestionPaper qpaper=new QuestionPaper();
		
			 qpaper.setId(id);
			 qpaper.setSem_id(sem_id);
			 qpaper.setDomain_name(domain_name);			
			 qpaper.setSub_code(sub_code);			
			 qpaper.setSubject(subject);			
			 qpaper.setYear1(sdf.format(year1));			
			 qpaper.setFilename(filename);
            list.add(qpaper);
			
			}
		}catch(Exception e){
		 System.out.println(e.getMessage());
	 }finally{
			try{
			dbcon.closeConnection(con);
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			
			
		}
		return list;
	}

}
