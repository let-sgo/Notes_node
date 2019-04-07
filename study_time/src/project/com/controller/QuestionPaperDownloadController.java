package project.com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.com.util.DbConnectionUtil;

/**
 * Servlet implementation class QuestionPaperDownloadController
 */
@WebServlet("/QuestionPaperDownloadController")
public class QuestionPaperDownloadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionPaperDownloadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id=Integer.parseInt(request.getParameter("id"));
			//String donwloadDir="E:\\ProjectImages\\";
		
			 Connection con = null;
			 PreparedStatement  pstmt  = null;
			 ResultSet rs  =null;
			 ServletOutputStream sos  = null;//to send to browser
				InputStream repDataIS  =null;//db to read
				
			 try {
					
					con = DbConnectionUtil.getConnection();
					String sql="select * from quetionpaper "
							+ " where id=?";
					pstmt = con.prepareStatement(sql);				
					pstmt.setLong(1, id);
					rs  = pstmt.executeQuery();
					if(rs.next()) {
						repDataIS  = rs.getBinaryStream("FILEDATA");
							String fileName=rs.getString("FILENAME");
							
							sos = response.getOutputStream();
							response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
							
							byte[]buff = new byte[1024];
							int length;
							while(  (length=repDataIS.read(buff))!=-1) {
								sos.write(buff, 0, length);
							}//read write data to browser
					}//if rs.next()
					
					
				}catch(SQLException e){
					System.out.println("db Error : " + e.getMessage());
					e.printStackTrace();
				}catch(Exception e){
					System.out.println("Error : " + e.getMessage());
					e.printStackTrace();
				}finally{
					
						try {
							repDataIS.close();
							sos.close();
							DbConnectionUtil.closeConnection(con);
						} catch (SQLException e) {
							e.printStackTrace();
						}
				 
				}//finally
				
	}

}
