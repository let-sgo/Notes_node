<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
 <title>Upload</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<!-- Trigger the modal with a button -->
<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-upload"> Upload</span></button>

<!-- Modal -->
<div id="myModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h2 class="modal-title" style="color:#42bcf4">upload</h2>
      </div>
      <div class="modal-body" style="border:5px solid #42bcf4;border-radius:15px;margin:4px">
<fieldset>
       <form  action="upload_notes" method="post" enctype="multipart/form-data">
<!--if sem is one then all sub of sem 1 would be fetche dfrom db-->
 <input type="hidden" name="subcode" value="<%=request.getParameter("subcode")%>">
 <input type="hidden" name="subname" value="<%=request.getParameter("subname")%>">
Choose file: <input type="file" name="file"> <br><br>
  <input type="submit" name="submit" value="upload"> <br><br>
</form>

<fieldset>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-primary" data-dismiss="modal" style="background-color:#42bcf4">Close</button>
      </div>
    </div>

  </div>
</div>

</body>



</html>
    