<%@page import="project.com.bo.ROLL_LIST"%>
<%@page import="project.com.dao.RollListDao"%>
<%@page import="project.com.bo.Notes"%>
<%@page import="project.com.dao.NotesDao"%>
<%@page import="project.com.bo.QuestionPaper"%>
<%@page import="project.com.dao.QuestionPaperDao"%>
<%@page import="project.com.bo.Subjects"%>
<%@page import="java.util.List"%>
<%@page import="project.com.dao.factory.DaoFactory"%>
<%@page import="project.com.dao.SubjectDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel ="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
    <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.2/semantic.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.js"> </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> 
<title>CSS Website Layout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
  box-sizing: border-box;
}

body {
  margin: 0;
}

/* Style the header */
.header {
  background-color: #f1f1f1;
  padding: 20px;
  text-align: center;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #333;
}

/* Style the topnav links */
.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  width: 33.33%;
  padding: 15px;
}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
  .column {
    width: 100%;
  }
}


h2{
  text-Align :right;
}
</style>
</head>
<%Object obj = request.getAttribute("emessage") ;
if(obj!=null){
String msg = (String)obj;
%>
<script>
alert("<%=msg%>");
</script>
<%}%>
<body>
<div class="ui container-fluid">

<h2 class="ui top attached header" style="margin-top:20px;">
	Admin Panel
</h2>

<div class="ui tabular menu" style="margin-top:20px;">
<%String subcode="";
QuestionPaperDao qpd = DaoFactory.getQuestionPaperDao();
for(int i=3;i<=8;i++){%>
  <a class="item" href="view_notes.jsp?sem=<%=i%>">
    <h4>Semester <%=i%></h4>
  </a>
 <%}%>
 <div class="item">
		<div class="btn-group">
			  <button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				 View Roll List
			  </button>
			  <div class="dropdown-menu">
			    <a class="dropdown-item" href="view_roll_list.jsp?year=2">2nd year</a>
			    <a class="dropdown-item" href="view_roll_list.jsp?year=3">3rd year</a>
			    <a class="dropdown-item" href="view_roll_list.jsp?year=4">4th year</a>
			 
			  </div>
			</div>
	</div>
</div>



<div class="ui grid">
  <div class="four wide column">
	<div class="ui vertical pointing menu" style="font-size:15px;">
	  <a class="active item">
		Functions
	  </a>
		  
	  <a class="item" href="FirstForm.jsp">Add Roll No By Year</a>
	  <a class="item" href="FirstForm1.jsp">Add Roll No By Year(slider)</a>
	  <a class="item" href="SecondForm.jsp">Delete Roll No By Year</a>
	  <a class="item" href="ThirdForm.jsp">Update Year</a>
	  <a class="item" href="FourthForm.jsp">Add Mail</a>
	   
	  
	  
	</div>
	  
	</div>
	
	 <div class="twelve wide column" >
  		
  				<h2 class="ui header" style="margin-top:15px;">
					
					<center>
					  <i class="book icon"></i>
					  <div class="content">
					<%
					String year = request.getParameter("year");
					%>
					<h3><%=year%></h3>
					  </div>
					  </center>
				</h2>
  				
  				
  		
			  <table class="ui single line table" style="margin-top:40px;">
				  <thead>
				    <tr>
				     
				      <th>YEAR</th>
				      <th>ROLL NO</th>
				      <th>DELETE</th>
				     			     
				    </tr>
				  </thead>
				  <%
				  int year1 = Integer.parseInt(year);
				  RollListDao rld = DaoFactory.getRollListDao();
				  List<ROLL_LIST> rlist = rld.getAllRollNo(year1);
				  for(ROLL_LIST roll : rlist){
				 %>
				  <tbody>
				    <tr>
				      <td><%=roll.getYear()%></td>
				      <td><%=roll.getId()%></td>
				      				    
				      <td><a href="delete_roll_number?rollno=<%=roll.getId()%>">delete this rollno</a></td>
				       
				    </tr>
				   		   
				  </tbody>
				  <%}%>
				</table>		 
  		</div>
  </div>
  
 


</body>
</html>
    