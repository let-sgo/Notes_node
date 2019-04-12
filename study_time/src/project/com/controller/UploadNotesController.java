package project.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
				
				
				FileItem fileItem1 = fileItemList.get(0);
				FileItem fileItem2 = fileItemList.get(1);
				  fileName = fileItem2.getName();
				  
				  String codeSub = fileItem1.getString().trim();
					String sub_code=codeSub.substring(0,codeSub.indexOf("$"));
					String subject=codeSub.substring(codeSub.indexOf("$")+1,codeSub.length());
					
				  int index=0;
				if((index=fileName.lastIndexOf('\\'))>=0){
				  fileName=fileName.substring(index+1,fileName.length());
				  }
				System.out.println("filename"+fileName);
				  fileData = fileItem2.getInputStream();
				int size  = (int)fileItem2.getSize();
				
				
				
				
				
				
				HttpSession session = request.getSession();
				Object obj1 = session.getAttribute("id");
				Object obj2 = session.getAttribute("sem");
				System.out.println("obj2"+obj2);
				Long id = (Long)obj1;
				
				int sem_id = Integer.parseInt((String)obj2);
				
				System.out.println("fn"+fileName);
				//System.out.println("data"+fileData);
				System.out.println("size"+size);
				System.out.println("sem_id"+sem_id);
				System.out.println("id"+id);
				System.out.println("subc"+sub_code);
				System.out.println("subn"+subject);
				
				Connection con = null;
				PreparedStatement pstmt= null;
				try {
					con = DbConnectionUtil.getConnection();
					String sql="insert into notes(sno,id,sem_id,sub_code,subject,file_name,file_data) values((select nvl(max(sno),0) + 1 from notes),?,?,?,?,?,?)";
					
					pstmt  = con.prepareStatement(sql);
					pstmt.setLong(1,id);
					pstmt.setInt(2,sem_id);
					pstmt.setString(3,sub_code);
					pstmt.setString(4,subject);
					pstmt.setString(5,fileName);
					pstmt.setBinaryStream(6, fileData,size);
					
					
					int totalInsert = pstmt.executeUpdate();
					if(totalInsert==1) {
						RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
						request.setAttribute("successmsg","notes successfully uploaded");
						rd.forward(request, response);
						
					}else {
						response.getWriter().print("error in uploading");
						response.sendRedirect("upload_notes.jsp");
					}
					
					
				} catch (Exception e) {
					response.getWriter().print("error in uploading");
					response.sendRedirect("upload_notes.jsp");
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


