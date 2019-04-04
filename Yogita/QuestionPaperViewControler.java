import java.sql.*;
import java.util.*;
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.servlet.*;
public class FirstPage extends GenericServlet{
	 
  public  void service(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response) 
  throws javax.servlet.ServletException, java.io.IOException{
	 PrintWriter pw=response.getWriter();
	 String sub_code=request.getParameter("sub_code");
	 String sem=request.getParameter("semester");
		  StringBuffer htmlContent =new StringBuffer();
	 htmlContent.append("<html>");
	 htmlContent.append("<head>");
	 
	 htmlContent.append("<link rel =\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css\" />");
	 htmlContent.append(" <script src=\"https://cdn.jsdelivr.net/semantic-ui/2.2.2/semantic.min.js\"></script>");
	 htmlContent.append(" <script src=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.js\"> </script>");
	 htmlContent.append("</head>");
	
	 htmlContent.append(" <body>");
	 htmlContent.append("  <div style=\" background-image: url('background.gif');\">");
	 htmlContent.append(" <div class=\"ui container-fluid\" style=\"margin-top : 50px; margin-left : 25px ; margin-right: 25px\"> ");
	 htmlContent.append(" <center> <h2 class=\"ui header\">Study Time</h2> </center> ");
	 htmlContent.append(" <div class=\"ui menu\">");
	 htmlContent.append(" <a class=\"item\">"+sem+"th Semester </a> ");
	 htmlContent.append("<div class=\"right menu\"> <a class=\"item\">Help</a>   </div> ");
	 htmlContent.append(" </div> ");
	 htmlContent.append(" <div class=\"ui grid\">");
	 htmlContent.append("<div class=\"row\"> ");
	 htmlContent.append(" <div class=\"four wide column\">");
	 htmlContent.append("<div class=\"ui vertical menu\">");
	 htmlContent.append("<div class=\"item\">");
	 htmlContent.append("  <div class=\"ui input\"><input type=\"text\" placeholder=\"Search...\"></div>");
	 htmlContent.append(" </div>");
	 htmlContent.append(" <div class=\"item\">");
	 htmlContent.append("<h1>subjects</h1>");
	 htmlContent.append(" <div class=\"menu\">");
	

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		con=DriverManager.getConnection(url,"System","Ig32mind$");

		String sql="select * from semester_subject where SEM_ID in(select SEM_ID from semester where semester=?)";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,sem); 
		rs=pstmt.executeQuery();		 
		while(rs.next()){	
		String sub_code=rs.getString(2);			 			
		String subject=rs.getString(3);	
		if(sub_code.equalsIgnoreCase(sub)){
		htmlContent.append("<a class=\"active item\" href=\"FirstPage.html?sub_code="+sub_code+"&semester="+sem+"\">"+subject+"  ( "+sub_code+" )"+"</a>");
		}else{
		htmlContent.append("<a class=\"item\" href=\"FirstPage.html?sub_code="+sub_code+"&semester="+sem+"\">"+subject+"  ( "+sub_code+" )"+"</a>");  
		}  
		}
		htmlContent.append("</div>");
		htmlContent.append("</div>");
		htmlContent.append("<a class=\"item\">");
		htmlContent.append("<h1>Messages</h1>");
		htmlContent.append("</a>");
		htmlContent.append("</div>");
		htmlContent.append("</div>");
		htmlContent.append("<div class=\"eight wide column\">");
		htmlContent.append("<h4 class=\"ui header\">CT1</h4>");
		htmlContent.append("<div>");
		String domain_name="CT1";
		int semint=Integer.parseInt(sem);
			int c=0;
			QuestionPaperDaoOracle qpo=new QuestionPaperDaoOracle();
		List<QuestionPaper> res= qpo.getQuestionPaperField(semint,domain_name,sub_code) ;
		Iterator r =res.iterator();
			while(r. hasNext()){
			QuestionPaper qpaper=r.next();
			String filename=qpaper.getFilename();
			
			
			String year=r.getYear1(); ;
			System.out.println("filename="+filename);
			if(c%4==1){
			htmlContent.append("<div class=\"row\">");
			}
			htmlContent.append("<div class=\"col-xs-3\" style=\"border:2px solid #009933;border-radius: 25px\"> ");
			
			htmlContent.append("<br><div style=\"font-size:2em;\">"+filename +" ("+year+" )");
			htmlContent.append("<div class=\"ui small basic icon buttons\" style=\"float:right\">");
			htmlContent.append("<a><span class=\"glyphicon glyphicon-download\"></span></a>");
			htmlContent.append("</div>");
			htmlContent.append("</div>");
			
			htmlContent.append("</div>");
			if(c%4==1){
			htmlContent.append("</div>");
			}
			}
			htmlContent.append("</div>");
			
			
			
			
			htmlContent.append("<h4 class=\"ui header\">CT2</h4>");
			htmlContent.append("<div>");
			String sql2="select * from  QUETIONPAPER where  DOMAIN_NAME='CT2' and SUB_CODE=? and SEM_ID in(select SEM_ID from semester where semester=?)";	
			pstmt=con.prepareStatement(sql2);
			pstmt.setString(1,sub);		 
			pstmt.setString(2,sem);		 
			rs=pstmt.executeQuery();
			int c1=0;
			while(rs.next()){
			c1++;
			String filename2=rs.getString("FILENAME");
			java.sql.Date year2=rs.getDate("YEAR1") ;
			System.out.println("filename="+filename2);
			if(c1%4==1){
			htmlContent.append("<div class=\"row\">");
			}
			htmlContent.append("<div class=\"col-xs-3\" style=\"border:2px solid #009933;border-radius: 25px\"> ");
			
			htmlContent.append("<br><div style=\"font-size:2em;\">"+filename2 +" ("+year2+" )");
			htmlContent.append("<div class=\"ui small basic icon buttons\" style=\"float:right\">");
			htmlContent.append("<a><span class=\"glyphicon glyphicon-download\"></span></a>");
			htmlContent.append("</div>");
			htmlContent.append("</div>");
			
			htmlContent.append("</div><br><br>");
			if(c1%4==1){
			htmlContent.append("</div>");
			}
			}
			htmlContent.append("</div>");
			
			
			
			htmlContent.append("<h4 class=\"ui header\">End Sem</h4>");
			htmlContent.append("<div >");
			String sql3="select * from  QUETIONPAPER where  DOMAIN_NAME='ENDSEM' and SUB_CODE=? and SEM_ID in(select SEM_ID from semester where semester=?)";	
			pstmt=con.prepareStatement(sql3);
			pstmt.setString(1,sub);		 
			pstmt.setString(2,sem);		 
			rs=pstmt.executeQuery();
			int c2=0;
			while(rs.next()){
			c2++;
			String filename3=rs.getString("FILENAME");
			java.sql.Date year3=rs.getDate("YEAR1") ;
			System.out.println("filename="+filename3);
			if(c2%4==1){
			htmlContent.append("<div class=\"row\">");
			}
			htmlContent.append("<div class=\"col-xs-3\" style=\"border:2px solid #009933;border-radius: 25px\"> ");
			
			htmlContent.append("<br><div style=\"font-size:2em;\">"+filename3 +" ("+year3+" )");
			htmlContent.append("<div class=\"ui small basic icon buttons\" style=\"float:right\">");
			htmlContent.append("<a><span class=\"glyphicon glyphicon-download\"></span></a>");
			htmlContent.append("</div>");
			htmlContent.append("</div><br><br>");
			
			htmlContent.append("</div><br><br>");
			if(c2%4==1){
			htmlContent.append("</div>");
			}
			}
			htmlContent.append("</div >");

	 }catch(Exception e){
		 System.out.println(e.getMessage());
	 }finally{
			try{
			if(con!=null){
				con.close();
			}
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			
			
		}
	 htmlContent.append("</div>");
	 htmlContent.append("<div class=\"four wide column\">");
	 htmlContent.append("<h4 class=\"ui header\">");
	 htmlContent.append("<div class=\"ui small basic icon buttons\">");
	 htmlContent.append("<button class=\"ui button\"><i class=\"file icon\"></i></button>");
	 htmlContent.append("<button class=\"ui button active\"><i class=\"upload icon\"></i></button>");
	 htmlContent.append("<button class=\"ui button\"><i class=\"download icon\"></i></button>");
	 htmlContent.append("</div>");
	 htmlContent.append("</h4>");
	 htmlContent.append("<div class=\"ui hidden divider\"></div>");
	 htmlContent.append("<h4 class=\"ui header\">");
	 htmlContent.append("	<div class=\"ui small basic icon buttons\">");
	 htmlContent.append("<button class=\"ui button\"><i class=\"file icon\"></i></button>");
	 htmlContent.append("<button class=\"ui button active\"><i class=\"upload icon\"></i></button>");
	 htmlContent.append("<button class=\"ui button\"><i class=\"download icon\"></i></button>");
	 htmlContent.append(" </div>");
	 htmlContent.append("</h4>");
	 htmlContent.append("<div class=\"ui hidden divider\"></div>");
	 htmlContent.append("<h4 class=\"ui header\">");
	 htmlContent.append("<div class=\"ui small basic icon buttons\">");
	 htmlContent.append("<button class=\"ui button\"><i class=\"file icon\"></i></button>");
	 htmlContent.append("<button class=\"ui button active\"><i class=\"upload icon\"></i></button>");
	 htmlContent.append("<button class=\"ui button\"><i class=\"download icon\"></i></button>");
	 htmlContent.append("</div>");
	 htmlContent.append("</h4>");
	 htmlContent.append("<div class=\"ui hidden divider\"></div>");
	 htmlContent.append("</div>");
	 htmlContent.append("</div>");
	 htmlContent.append("</div>");
	 htmlContent.append("</div>");
	 htmlContent.append("</div>"); 
	htmlContent.append("</body>");
	htmlContent.append("/<html>");
	response.setContentType("text/html");
	pw.print(htmlContent);
}
		
   }
