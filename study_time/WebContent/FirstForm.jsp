<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
     <div style=" background-image: url('background.png');">

        <div class="ui container-fluid" style="margin-top : 50px; margin-left : 25px ; margin-right: 25px">
           <center>
             <div style="margin-top:20px;">
                <i class="ui user circle huge icon"></i>
            </div>
                <h2 class="ui header">Study Time</h2>
            </center>

            <div class="ui menu">
                    <a class="item">Hello Admin</a>
                    <div class="right menu">
                      <a class="item">Logout</a>
                    </div>
           </div>

            <div class="ui grid">
                    <div class="row">

                        <div class="four wide column"></div>

                        <div class="eight wide column">

                                            <!-- <button class="ui red right floated button" id="myButton">
                                                        <i class="ui upload icon"></i>
                                                        Upload
                                            </button> -->


												<form action="add_rollno" method="post">
                                            <div class="ui fluid action input" style="margin-top:30px;">
                                              <input name="rollno" type="text" placeholder="Enter Starting Roll No..">
                                            </div>

                                            <div class="ui fluid action input" style="margin-top:30px;">
                                              <input type="text" name="total_student" placeholder="Total Students..">
                                            </div>

                                            <select name="year" class="custom-select custom-select-lg mb-3" style="margin-top:30px;">
                                                      <option selected>Enter Year </option>
                                                      <option value="2">2nd Year</option>
                                                      <option value="3">3rd Year</option>
                                                      <option value="4">4th Year</option>
                                              </select>


                                              <div class="form-group" style="margin-top:30px;"> <!-- Submit button -->
                                                <button class="btn btn-primary " name="submit" type="submit">Upload</button>
                                            </div>
												</form>



                                <br>
                                <br><br>
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