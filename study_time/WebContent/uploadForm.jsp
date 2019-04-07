<%@page import="project.com.dao.SubjectDao"%>
<%@page import="project.com.dao.factory.DaoFactory"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="project.com.bo.Subjects"%>
<html> 
<head>
    <link rel ="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.min.css" />
    <script src="https://cdn.jsdelivr.net/semantic-ui/2.2.2/semantic.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.4.1/semantic.js"> </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
        <!--  jQuery -->
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>

    <!-- Isolated Version of Bootstrap, not needed if your site already uses Bootstrap -->
    <link rel="stylesheet" href="https://formden.com/static/cdn/bootstrap-iso.css" />

    <!-- Bootstrap Date-Picker Plugin -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
    
    <script>
    $(document).ready(function(){
      var date_input=$('input[name="date"]'); //our date input has the name "date"
      var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
      var options={
        format: 'mm/dd/yyyy',
        container: container,
        todayHighlight: true,
        autoclose: true,
      };
      date_input.datepicker(options);
    })
    </script>
   <style>
         
    </style>
</head>
 <body>
     <div style=" background-image: url('background.gif');">
    
        <div class="ui container-fluid" style="margin-top : 50px; margin-left : 25px ; margin-right: 25px">
           <center>
                <h2 class="ui header">Study Time</h2>
            </center>
            <% Object obj1=session.getAttribute("username");
             Object obj2=session.getAttribute("sem");
             int sem2=Integer.parseInt((String)obj2);
             %>
            <div class="ui menu">
             <%if(sem2!=3){
            	 %>
            	   <a class="item"><%=sem2%>th semester</a>
           <%   }else{ %>
        	    <a class="item"><%=sem2%>rd semester</a>
           <%  }
             %>
                  
                    <div class="right menu">
                      <a class="item">Help</a>
                    </div>
           </div>

            <div class="ui grid">
                    <div class="row">
                       
                        <div class="four wide column"></div>

                        <div class="eight wide column">
                        <form class="ui form" action="upload_question_paper" method="post" enctype="multipart/form-data">
                                       
                                            <!-- <button class="ui red right floated button" id="myButton">
                                               
                                                        <i class="ui upload icon"></i> 
                                                        Upload 
                                                
                                            </button> -->

                                            <div><h2 class="ui icon center aligned header"><i aria-hidden="true" class="ui upload icon"></i><div class="content">Upload</div></h2></div>
                                      
                                            <select class="custom-select custom-select-lg mb-3" name="domain_name" style="margin-top:15px;">
                                                    <option selected>Enter Exam (CT1, CT2 ,END-SEM) </option>
                                                    <option value="CT1">CT1</option>
                                                    <option value="CT2">CT2</option>
                                                    <option value="ENDSEM">ENDSEM</option>
                                            </select>
                                            <select class="custom-select custom-select-lg mb-3" name="sub_code" style="margin-top:15px;">
											  <% Object obj4 = session.getAttribute("sem");
                                        String sem1 = (String)obj4;
                                        SubjectDao sd = DaoFactory.getSubjectDao();
                                        List<Subjects> sub = new ArrayList<Subjects>();
                              		  sub=sd.getSubject(Integer.parseInt(sem1));
                              		
                                        for(Subjects list1 : sub){
                                        	String sub_code1=list1.getSub_code();			 			
                                    		String subject1=list1.getSubject();
                                    		String sub_code2=sub_code1+"$"+subject1;
                                    		%>
                                    		
                                    		   <option value="<%=sub_code2%>"><%=subject1%></option>
                                    									
                                          <% }%>
											   
                                            </select>
											                                                
                                            <div class="custom-file" style="margin-top:15px;">
                                                   Choose file: <input type="file" name="file"> 
                              
                                            </div>

                                            <br>
                                <br><br>
                                            <div class="form-group" style="margin-top:15px;"> <!-- Date input -->
                                                <label class="control-label" for="date">Date of Paper</label>
                                                <input class="form-control" id="date" name="date" placeholder="MM/DD/YYY" type="text"/>
                                              </div>
                                              <div class="form-group"> <!-- Submit button -->
                                                <button class="btn btn-primary " name="submit" type="submit">Upload</button>
                                            </div>
                                                        
                                            

                                        
                                <br>
                                <br><br>
                                </form>
                             </div>   

                             <div class="four wide column">

                             </div>

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




