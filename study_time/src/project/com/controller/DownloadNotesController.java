package project.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.util.DbConnectionUtil;

/**
 * Servlet implementation class DownloadNotesController
 */
@WebServlet("/DownloadNotesController")
public class DownloadNotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadNotesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream sos  = null;//to send to browser
		InputStream repDataIS  =null;//db to read
		
		
		  //response.setContentType("APPLICATION/OCTET-STREAM"); 
		 // response.setHeader("Content-Disposition", "attachment; filename=\""+file.getName()+"\""); 
		 // response.setHeader("Content-Disposition", "attachment; filename=\""+System.currentTimeMillis()+"_"+file.getName()+"\""); 
		  
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		String sn = request.getParameter("sno");
		Long sno = Long.parseLong(sn);
		try {
			con = DbConnectionUtil.getConnection();
			String sql = "select * from notes where sno=?";
			pstmt  = con.prepareStatement(sql);
			pstmt.setLong(1,sno);
			rs =pstmt.executeQuery();
			if(rs.next()) {
					String fileName = rs.getString("file_name");
					repDataIS  = rs.getBinaryStream("file_data");
					
					 
					sos = response.getOutputStream();
					response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
					
					byte[]buff = new byte[1024];
					int length;
					while(  (length=repDataIS.read(buff))!=-1) {
						sos.write(buff, 0, length);
					}//read write data to browser
			}//if rs.next()
			
		} catch (Exception e) {
		    e.printStackTrace();
		}finally {
			
			try {
				sos.close();
				DbConnectionUtil.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//finally
		
		
		
	}

	

}
