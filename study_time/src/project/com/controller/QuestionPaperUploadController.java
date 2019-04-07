package project.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.mail.Session;
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
 * Servlet implementation class QuestionPaperUploadController
 */
@WebServlet("/QuestionPaperUploadController")
public class QuestionPaperUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionPaperUploadController() {
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
				FileItem fileItem3 = fileItemList.get(2);
				FileItem fileItem4 = fileItemList.get(3);
				  fileName = fileItem3.getName();
				  fileData = fileItem3.getInputStream();
				int size  = (int)fileItem3.getSize();
				
				String domain_name = fileItem1.getString().trim();
				String codeSub = fileItem2.getString().trim();
				String sub_code=codeSub.substring(0,codeSub.indexOf("$"));
				String subject=codeSub.substring(codeSub.indexOf("$")+1,codeSub.length());
				String year=fileItem4.getString().trim();
				
				
				HttpSession session = request.getSession();
				//Object obj1 = session.getAttribute("id");
				Object obj2 = session.getAttribute("sem");
				//Long id = (Long)obj1;
				int sem_id = Integer.parseInt((String)obj2);
				
				System.out.println("fn"+fileName);
			
				System.out.println("size"+size);
				System.out.println("sem_id"+sem_id);
				//System.out.println("id"+id);
				System.out.println("subc"+sub_code);
				System.out.println("subn"+subject);
				System.out.println("year"+year.getClass());
				System.out.println("year"+year);
				
				Connection con = null;
				PreparedStatement pstmt= null;
				try {
					con = DbConnectionUtil.getConnection();
					String sql="insert into quetionpaper values(qp.nextval,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					//set date
					
					pstmt.setLong(1,sem_id);
					pstmt.setString(2, domain_name);
					pstmt.setString(3,sub_code);
					pstmt.setString(4,subject);
					java.util.Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(year);
					
					System.out.println("date"+date1);
					

					pstmt.setDate(5,(new java.sql.Date(date1.getTime())));
					pstmt.setString(6,  fileName);
					pstmt.setBinaryStream(7, fileData,size);
					int totalInsert = pstmt.executeUpdate();
					if(totalInsert==1) {
						response.getWriter().print("successfully uploading to database ");
						try{
						Thread.sleep(5000);
						}catch(Exception e){
							response.getWriter().print("cannot be uploaded due to internal error");	
						}
						response.sendRedirect("index_landing3.jsp");
						
					}else {
						response.getWriter().print("error in uploading to database ");			
									
						response.sendRedirect("upload_notes.jsp");
					}
					
					
				} catch (Exception e) {
					response.getWriter().print("error in uploading");
					e.printStackTrace();
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
