package project.com.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.mail.Session;
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
				//  fileName = fileItem3.getName();
				fileName = System.currentTimeMillis()+"";
				  fileData = fileItem3.getInputStream();
				int size  = (int)fileItem3.getSize();
				
				String domain_name = fileItem1.getString().trim();
				String codeSub = fileItem2.getString().trim();
				String sub_code=codeSub.substring(0,codeSub.indexOf("$"));
				String subject=codeSub.substring(codeSub.indexOf("$")+1,codeSub.length());
				String year=fileItem4.getString().trim();
				
				String nyear = year.substring(year.lastIndexOf('/')+1,year.length());
				HttpSession session = request.getSession();
				Object obj1 = session.getAttribute("id");
				Object obj2 = session.getAttribute("sem");
				Long id1 = (Long)obj1;
				int sem_id = Integer.parseInt((String)obj2);
				
				System.out.println("fn"+fileName);
			
				System.out.println("size"+size);
				System.out.println("sem_id"+sem_id);
				System.out.println("id"+id1);
				System.out.println("subc"+sub_code);
				System.out.println("subn"+subject);
				System.out.println("year"+year.getClass());
				System.out.println("year"+year);
				System.out.println("nyear"+nyear);
				
				Connection con = null;
				PreparedStatement pstmt= null;
				try {
					con = DbConnectionUtil.getConnection();
					String sql="insert into questionpaper values(?,?,?,?,?,?,?,?)";
					pstmt = con.prepareStatement(sql);
					//set date
					pstmt.setLong(1,id1);
					pstmt.setLong(2,sem_id);
					pstmt.setString(3, domain_name);
					pstmt.setString(4,sub_code);
					pstmt.setString(5,subject);
					pstmt.setString(6,nyear);
					pstmt.setString(7,  fileName);
					pstmt.setBinaryStream(8, fileData,size);
					int totalInsert = pstmt.executeUpdate();
					if(totalInsert==1) {
						RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
						request.setAttribute("successmsg","question paper sucessfully uploaded");
						rd.forward(request,response);
						
					}else {
						response.getWriter().print("error in uploading to database ");			
									
						response.sendRedirect("uploadForm.jsp");
					}
					
					
				} catch (SQLException e) {
					RequestDispatcher rd = request.getRequestDispatcher("uploadForm.jsp");
					request.setAttribute("ermessage","this year question paper already uploaded");
					rd.forward(request, response);
					e.printStackTrace();
					
				} catch (Exception e) {
					response.getWriter().print("error in uploading");
					e.printStackTrace();
					response.sendRedirect("uploadForm.jsp");
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
