package project.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import project.com.util.DbConnectionUtil;

/**
 * Servlet implementation class UploadNotesController
 */
@WebServlet("/UploadNotesController")
public class UploadNotesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadNotesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		  boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		  if(isMultipart) {
			 
			  ServletFileUpload uploadUtil = null;
			  uploadUtil = new ServletFileUpload(new DiskFileItemFactory());
			  try {
				List <FileItem>fileItemList = uploadUtil.parseRequest(request);
				
				String fileName = null;
				InputStream fileData = null;
				
				FileItem fileItem = fileItemList.get(0);
				FileItem fileItem1 = fileItemList.get(1);
				FileItem fileItem2 = fileItemList.get(2);
				  fileName = fileItem2.getName();
				  fileData = fileItem2.getInputStream();
				int size  = (int)fileItem2.getSize();
				
				String subcode = fileItem.getString().trim();
				String subname = fileItem1.getString().trim();
				
				
				
				
				HttpSession session = request.getSession();
				Object obj1 = session.getAttribute("id");
				Object obj2 = session.getAttribute("sem");
				Long id = (Long)obj1;
				int sem_id = Integer.parseInt((String)obj2);
				
				System.out.println("fn"+fileName);
				System.out.println("data"+fileData);
				System.out.println("size"+size);
				System.out.println("sem_id"+sem_id);
				System.out.println("id"+id);
				System.out.println("subc"+subcode);
				System.out.println("subn"+subname);
				
				Connection con = null;
				PreparedStatement pstmt= null;
				try {
					con = DbConnectionUtil.getConnection();
					String sql="insert into notes(sno,id,sem_id,sub_code,subject,file_name,file_data) values((select nvl(max(sno),0) + 1 from notes),?,?,?,?,?,?)";
					
					pstmt  = con.prepareStatement(sql);
					pstmt.setLong(1,id);
					pstmt.setInt(2,sem_id);
					pstmt.setString(3,subcode);
					pstmt.setString(4,subname);
					pstmt.setString(5,fileName);
					pstmt.setBinaryStream(6, fileData,size);
					
					
					int totalInsert = pstmt.executeUpdate();
					if(totalInsert==1) {
						response.sendRedirect("index_landing3.jsp");
						
					}else {
						response.getWriter().print("error in uploading");
						response.sendRedirect("upload_notes.jsp");
					}
					
					
				} catch (Exception e) {
					response.getWriter().print("error in uploading");
				}finally {
					try {
						DbConnectionUtil.closeConnection(con);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				
				
				
				
			  } catch (FileUploadException e) {
				e.printStackTrace();
			  }
			
		  }//is multipart 
	}

}


