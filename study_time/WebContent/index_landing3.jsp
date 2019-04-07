<%@page import="java.util.ArrayList"%>
<%@page import="project.com.bo.Subjects"%>
<%@page import="java.util.*"%>
<%@page import="project.com.dao.factory.DaoFactory"%>
<%@page import="project.com.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html> 
<head>
    <link rel ="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
    <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.2/semantic.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.js"> </script>
</head>
 <body>
     <div style=" background-image: url('background.gif');">
     <div class="ui container-fluid" style="margin-top : 50px; margin-left : 25px ; margin-right: 25px">
           <center>
                <h2 class="ui header">Study Time</h2>
            </center>
            <% Object obj1=session.getAttribute("username");
             Object obj2=session.getAttribute("sem");
            if(obj1!=null){
            String username=(String)obj1;%>
           <h4>hello <%=username%></h4>
           <%}if(obj2!=null){
           String sem =(String)obj2;
          if(!sem.equals("3")){%>
           <a href="logout">Log Out</a>
            <div class="ui menu">
                    <a class="item"><%=sem%>th semester</a>
                    <div class="right menu">
                      <a class="item">Help</a>
                    </div>
           </div>
		<%}else{%>
		 <a href="logout">Log Out</a>
            <div class="ui menu">
                    <a class="item"><%=sem%>rd semester</a>
                    <div class="right menu">
                      <a class="item">Help</a>
                    </div>
           </div>
           <%}} %>
            <div class="ui grid">
                    <div class="row">
                        <div class="four wide column">

                                <div class="ui vertical menu">
                                        <div class="item">
                                        <div class="ui input"><input type="text" placeholder="Search..."></div>
                                        </div>
                                        <div class="item">
                                        SUBJECTS
                                        <div class="menu">
                                         <a href="dashboard.jsp" class="active item">Home</a>
                                        <% Object obj4 = session.getAttribute("sem");
                                        String sem1 = (String)obj4;
                                        SubjectDao sd = DaoFactory.getSubjectDao();
                                        List<Subjects> sub = new ArrayList<Subjects>();
                              		  sub=sd.getSubject(Integer.parseInt(sem1));
                              		
                                        for(Subjects list1 : sub){
                                        	String sub_code1=list1.getSub_code();			 			
                                    		String subject1=list1.getSubject();	     	
									 %>
								<a class="item" href="dashboardNext.jsp?sub_code=<%=sub_code1 %>&semester=<%=sem1%>"><%=subject1 %></a>
									 <%
                                            }%>
                                        </div>
                                        </div>
                                    
                                        <a class="item">
                                        Messages
                                        </a>
                                    
                                </div>
                        </div>

                        
                        
                        <div class="four wide column">

                                <h4 class="ui header">
                                        <div class="ui small basic icon buttons">
                                                <button title='file' class="ui button"><i class="file icon"></i></button>
                                                <button title='upload' class="ui button active"><i class="upload icon"></i></button>
                                                <button title='download' class="ui button"><i class="download icon"></i></button>
                                              </div>
                                </h4>

                                <div class="ui hidden divider"></div>
                              
                                <h4 class="ui header">
                                        <div class="ui small basic icon buttons">
                                                <button title='file' class="ui button"><i class="file icon"></i></button>
                                                <button title='upload' class="ui button active"><i class="upload icon"></i></button>
                                                <button title='download' class="ui button"><i class="download icon"></i></button>
                                              </div>
                                </h4>
                                <div class="ui hidden divider"></div>
                             
                                <h4 class="ui header">

                                        <div class="ui small basic icon buttons">
                                                <button title='file' class="ui button"><i class="file icon"></i></button>
                                                <button title='upload' class="ui button active"><i class="upload icon"></i></button>
                                                <button title='download' class="ui button"><i class="download icon"></i></button>
                                         </div>

                                </h4>

                                <div class="ui hidden divider"></div>
                                 <h4 class="ui header">
											<%String subcode = request.getParameter("sub_code1");
											String subname = request.getParameter("subject1");%>
                                        <div class="ui small basic icon buttons">
                                                 <a href="download_notes"><button title='file' class="ui button"><i class="file icon"></i></button></a>
                                                <a href="upload_notes.jsp?subcode=<%=subcode%>&subname=<%=subname%>"><button title='upload' class="ui button active"><i class="upload icon"></i></button></a>
                                                <a href="download_notes"><button title='download' class="ui button"><i class="download icon"></i></button></a>
                                         </div>

                                </h4>

                                <div class="ui hidden divider"></div>


                        </div>
                    </div>
                  
              
                </div>
                   
             </div>

    </div>

    <div class="ui inverted vertical footer segment" style="margin-top :10px;">
            <div class="ui center aligned container">
              <div class="ui stackable inverted divided grid">
                <div class="two wide column">
                  <h4 class="ui inverted header">Yash Khurana</h4>
                
                </div>
                <div class="two wide column">
                  <h4 class="ui inverted header">Yogita Upadhyay</h4>
                  
                </div>
                <div class="two wide column">
                  <h4 class="ui inverted header">Arpita Gauraha</h4>
                  
                </div>

                <div class="two wide column">
                        <h4 class="ui inverted header">Shruti Sinha</h4>
                        
                        </div>

                <div class="eight wide column">
                  <h4 class="ui inverted header">Study Time</h4>
                  <p>A Question and Notes bank App</p>
                </div>
              </div>
              <div class="ui inverted section divider"></div>
              <div class="ui horizontal inverted small divided link list">
                <a class="item" href="#">Site Map</a>
                <a class="item" href="#">Contact Us</a>
                <a class="item" href="#">Terms and Conditions</a>
                <a class="item" href="#">Privacy Policy</a>
              </div>
            </div>
          </div>
 </body>   
</html>
    