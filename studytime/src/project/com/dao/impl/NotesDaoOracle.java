package project.com.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import project.com.dao.NotesDao;
import project.com.util.DbConnectionUtil;

public class NotesDaoOracle implements NotesDao{

	@Override
	public boolean makeAvailable(long sno) {
		Connection con = null;
		PreparedStatement pstmt = null;
        boolean isUpdated = false;
        
        try {
			con = DbConnectionUtil.getConnection();
			String sql = "update notes set uploaded=? where sno=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "true");
			pstmt.setLong(2, sno);
						
			
			if(pstmt.executeUpdate()>0)
				isUpdated = true;

		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			try {
				DbConnectionUtil.closeConnection(con);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return isUpdated;
		
	}

}
