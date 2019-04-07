package project.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import project.com.bo.User;
import project.com.dao.UserDao;
import project.com.util.DbConnectionUtil;
import project.com.util.EmailSend;

public class UserDaoOracle implements UserDao{

	@Override
	public String generatePassword() {
		StringBuffer sb = new StringBuffer();
		String fp="abcdefghijklmnopqrstuvwxyz";
		Random rand = new Random();
		for(int i=1;i<=4;i++){
			int ans = rand.nextInt(26);
			sb.append(fp.charAt(ans));
		}
		Integer ans2 = rand.nextInt(999)+100;
		sb.append(ans2.toString());
		return sb.toString();
	}

	@Override
	public boolean isRollNoExist(long roll_no) {
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql="select * from roll_no where id="+roll_no;
			rs = stmt.executeQuery(sql);
			if(rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return false;
	}

	@Override
	public boolean register(long roll_no, String fname, String lname,
			String email) {
		Connection con=null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		int result1=0;
		int result2=0;
		try {
			con = DbConnectionUtil.getConnection();
			con.setAutoCommit(false);
			String password = generatePassword();
			String sql2 = "insert into login values(?,?)";
			pstmt2=con.prepareStatement(sql2);
			pstmt2.setLong(1,roll_no);
			pstmt2.setString(2,password);
			result2 = pstmt2.executeUpdate();
			
		
			
			String sql="insert into register values(?,?,?,?)";
			pstmt1 = con.prepareStatement(sql);
			pstmt1.setLong(1,roll_no);
			pstmt1.setString(2,fname);
			pstmt1.setString(3,lname);
			pstmt1.setString(4,email);
			result1=pstmt1.executeUpdate();
			
			
			
			System.out.println("result1="+result1);
			System.out.println("result2="+result2);
			EmailSend es = new EmailSend(password,roll_no,email,fname);
			boolean result3  = es.sendMail();
			
			System.out.println("result3="+result3);
			if(result1==1 && result2==1 && result3){
				con.commit();
				return true;
				
			}else{
				try {
					con.rollback();
					System.out.println("rollback success");
				} catch (Exception e2) {
					System.out.println("rollback problem");
				}
				return false;
			}
		} catch (Exception e) {
			
			try {
				con.rollback();
				System.out.println("rollback success");
			} catch (Exception e2) {
				System.out.println("rollback problem");
			}
			System.out.println(e.getMessage());
			return false;
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
		
	}

	@Override
	public boolean userExist(long roll_no) {
		Connection con=null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DbConnectionUtil.getConnection();
			stmt = con.createStatement();
			String sql="select * from register where id="+roll_no;
			rs = stmt.executeQuery(sql);
			if(rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return false;
	}

	@Override
	public boolean isValidUser(long id, String password) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DbConnectionUtil.getConnection();
			String sql="select * from login where id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,id);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if(rs.next())
				return true;
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		return false;
		
	}

	@Override
	public User getUser(long id) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			con = DbConnectionUtil.getConnection();
			String sql="select * from register where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1,id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user = new User();
				String fname=rs.getString("fname");
				String lname=rs.getString("lname");
				String email=rs.getString("email");
				user.setEmail(email);
				user.setFname(fname);
				user.setId(id);
				user.setLname(lname);
				user.setPassword(null);
				return user;
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
		
		return user;
	}

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

}
