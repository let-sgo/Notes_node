package project.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.QuestionPaper;
import project.com.bo.ROLL_LIST;
import project.com.dao.RollListDao;
import project.com.util.DbConnectionUtil;

public class RollListDaoOracle implements RollListDao{
	@Override
	public boolean enterRollNo(long start, int totalStudent, int year) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stmt = null;
	
		Boolean result1=false;
		try {
			con = DbConnectionUtil.getConnection();
			
			
			String sql2="select nvl(max(id),"+start+")+1 from roll_no where year"
					+ "="+year+"and isSlider = \'n\'";
			String sql3="insert into roll_no values(("+sql2+"),"+year+",\'n\')";
			String sql4 = "insert into roll_no values(("+start+"),"+year+",\'n\')";
			int x=2;
			stmt=con.createStatement();
			int result = stmt.executeUpdate(sql4);
			if(result==1){
			while(x<=totalStudent){
				stmt=con.createStatement();
				 result = stmt.executeUpdate(sql3);
				if(result==1)
					result1=true;
				else
					result1=false;
				x++;
				
			}
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		
		
		
		return result1;
		
	}

	@Override
	public boolean enterRollNoSlider(long start, int totalStudent, int year) {
		Connection con=null;
		Statement stmt = null;
	
		Boolean result1=false;
		try {
			con = DbConnectionUtil.getConnection();
			
			
			String sql2="select nvl(max(id),"+start+")+1 from roll_no where year"
					+ "="+year+"and isSlider = \'y\'";
			String sql3="insert into roll_no values(("+sql2+"),"+year+",\'y\')";
			String sql4 = "insert into roll_no values(("+start+"),"+year+",\'y\')";
			int x=2;
			stmt=con.createStatement();
			int result = stmt.executeUpdate(sql4);
			if(result==1){
			while(x<=totalStudent){
				stmt=con.createStatement();
				 result = stmt.executeUpdate(sql3);
				if(result==1)
					result1=true;
				else
					result1=false;
				x++;
				
			}
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		
		
		
		return result1;
		
	}

	@Override
	public boolean deleteStudentByYear(int year) {
		Connection con=null;
		Statement stmt = null;
		
		Boolean result1=true;
		try {
			con = DbConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql="delete from roll_no where year="+year;
			int result = stmt.executeUpdate(sql);
			if(result==1)
				result1=true;
			if(result==0)
				result1=false;
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		
		return result1;
	}

	@Override
	public boolean updateYear(int previousYear, int updatedYear) {
		Connection con=null;
		Statement stmt = null;
		
		Boolean result1=true;
		try {
			con = DbConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql="update roll_no set year="+updatedYear+"where year="+previousYear;
			int result = stmt.executeUpdate(sql);
			if(result==1)
				result1=true;
			if(result==0)
				result1=false;
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		
		return result1;	
	
	}

	
	@Override
	public List<ROLL_LIST> getAllRollNo(int year) {

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		List<ROLL_LIST>list=new ArrayList<ROLL_LIST>();
		try{
		con=DbConnectionUtil.getConnection();
         String sql1="select * from  roll_no where year=?";	
			pstmt=con.prepareStatement(sql1);
					 
			pstmt.setInt(1,year);		 
			rs=pstmt.executeQuery();
			
			while(rs.next()){
           
			 int year1 = rs.getInt(2);
			 int rollno  = rs.getInt(1);
			 String isSlider  = rs.getString(3);
			 ROLL_LIST rl = new ROLL_LIST();
			 rl.setId(rollno);
			 rl.setYear(year1);
			 rl.setIsSlider(isSlider);
			list.add(rl);
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
