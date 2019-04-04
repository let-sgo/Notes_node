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
	 
	 htmlContent.append(" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">");
	 htmlContent.append(" <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");
	 htmlContent.append("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>");
	 
	 htmlContent.append("<link rel =\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css\" />");
	 htmlContent.append(" <script src=\"https://cdn.jsdelivr.net/semantic-ui/2.2.2/semantic.min.js\"></script>");
	 htmlContent.append(" <script src=\"https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.js\"> </script>");
	 htmlContent.append("</head>");
	
	 htmlContent.append(" <body>");
	 htmlContent.append("  <div style=\" background-image: url('background.png');\">");
	 htmlContent.append(" <div class=\"ui container-fluid\" style=\"margin-top : 50px; margin-left : 25px ; margin-right: 25px\"> ");
	 htmlContent.append(" <center> <h2 class=\"ui header\">Study Time</h2> </center> ");
	 htmlContent.append(" <div class=\"ui menu\">");
	 htmlContent.append(" <a class=\"item\">"+sem+"th Semester </a> ");
	 htmlContent.append("<div class=\"right menu\"> <a class=\"item\"> <button class=\"ui button\" data-toggle=\"modal\" data-target=\"#myModal\"><i class=\"upload icon\"></i></button></a> <a class=\"item\">Help</a>   </div> ");
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
	


		SubjectDao sd=DaoFactory.getSubjectDao();
		List<Subjects>s= sd.getSubject(6);
		Iterator i =s.iterator();
		while(i.hasNext()){	
		Subjects subject=(Subjects)i.next();
		String sub_code1=subject.getSub_code();			 			
		String subject1=subject.getSubject();	
		if(sub_code1.equalsIgnoreCase(sub_code)){
		htmlContent.append("<a class=\"active item\" href=\"FirstPage.html?sub_code="+sub_code1+"&semester="+sem+"\">"+subject1+"  ( "+sub_code+" )"+"</a>");
		}else{
		htmlContent.append("<a class=\"item\" href=\"FirstPage.html?sub_code="+sub_code1+"&semester="+sem+"\">"+subject1+"  ( "+sub_code+" )"+"</a>");  
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
		htmlContent.append("<center><h1 class=\"ui header\">CT1</h1></center>");
		int semint=Integer.parseInt(sem);
		String domain_name="CT1";
		QuestionPaperDao qpo=DaoFactory.getQuestionPaperDao();
		List<QuestionPaper> res= qpo.getQuestionPaperField(semint,domain_name,sub_code) ;		
		Iterator r =res.iterator();
		while(r. hasNext()){
		QuestionPaper qpaper=(QuestionPaper)r.next();
		String filename=qpaper.getFilename();
		int id=qpaper.getId();	
		String year=qpaper.getYear1(); 
		//System.out.println("filename="+filename);
		htmlContent.append("<div class=\"ui blue label\">");
		htmlContent.append("<a href=\"QuestionPaperDownloadControler.html?id="+id+"\" >  "+filename +" ("+year+" )  <i class=\"download icon\" style=\"float:right\"></i></a> ");
		htmlContent.append("</div><br><br>");
		}
		htmlContent.append("<div class=\"ui hidden divider\"></div>");
		



		htmlContent.append("<center><h1 class=\"ui header\">CT2</h1></center>");
		domain_name="CT2"; 
		res=qpo.getQuestionPaperField(semint,domain_name,sub_code) ;
		r=res.iterator();
		
		while(r. hasNext()){
		QuestionPaper qpaper=(QuestionPaper)r.next();
		String filename2=qpaper.getFilename();
        int id2=qpaper.getId();			
		String year2=qpaper.getYear1(); ;
		System.out.println("filename="+filename2);	
		htmlContent.append("<div class=\"ui blue label\">");
		htmlContent.append("<a href=\"QuestionPaperDownloadControler.html?id="+id2+"\">  "+filename2 +" ("+year2+" )  <i class=\"download icon\" style=\"float:right\"></i></a> ");
		htmlContent.append("</div><br><br>");
		}
		htmlContent.append("<div class=\"ui hidden divider\"></div>");
		
		
		

		htmlContent.append("<center><h1 class=\"ui header\">ENDSEM</h1></center>");
		
		domain_name="ENDSEM";
		res= qpo.getQuestionPaperField(semint,domain_name,sub_code) ;
		r =res.iterator();
		int c2=0;
		while(r. hasNext()){
		QuestionPaper qpaper=(QuestionPaper)r.next();
		String filename3=qpaper.getFilename();	
        int id3=qpaper.getId();		
		String year3=qpaper.getYear1(); ;
		
		htmlContent.append("<div class=\"ui blue label\">");
		htmlContent.append("<a href=\"QuestionPaperDownloadControler.html?id="+id3+"\">  "+filename3 +" ("+year3+" )  <i class=\"download icon\" style=\"float:right\"></i></a> ");
		htmlContent.append("</div><br><br>");
		}
		htmlContent.append("<div class=\"ui hidden divider\"></div>");
		htmlContent.append("</div >");
		
	
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
