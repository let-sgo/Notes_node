package project.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import project.com.bo.Subjects;
import project.com.bo.User;
import project.com.dao.SubjectDao;
import project.com.util.DbConnectionUtil;

public class SubjectDaoOracle implements SubjectDao{

	@Override
	public List<Subjects> getSubject(int sem_id) {
		Connection con=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Subjects> list = null;
		try {
			con = DbConnectionUtil.getConnection();
			String sql="select * from semester_subject where sem_id="+sem_id;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Subjects>();
			while(rs.next()){
				Subjects sub= new Subjects();
				String sc =rs.getString(2);
				String subject=rs.getString(3);
				sub.setSem_id(sem_id);
				sub.setSub_code(sc);
				sub.setSubject(subject);
				list.add(sub);
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
		
		return list;
	}

		
	

}
