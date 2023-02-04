<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BUG TRACKER</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" >
<!-- JavaScript Bundle with Popper -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Project Assignment</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Assign Project</div>
    </div>
    <div class="panel-body">
     <form:form action="updateAssignment" cssClass="form-horizontal"
      method="post" modelAttribute="projectAssignment">

      <!-- need to associate this data with customer id -->
      <form:hidden path="assignmentId" />
      <form:hidden path="projectId"  />
        <form:hidden path="assignedId"  />
         <form:hidden path="createdDate"  />
        <form:hidden path="assignmentDate"  />
        <form:hidden path="createdBy"  />
    
       
          <div class="form-group">
       <label for="projectId" class="col-md-3 control-label">Project name:</label>
       <div class="col-md-9">
        <textarea > ${projectAssignment.projectName}</textarea>
       </div>
      </div>
        
        
        <div class="form-group">
       <label for="role" class="col-md-3 control-label">Role:</label>
      <textarea > ${projectAssignment.roleName}</textarea>
        </div>    
        
         <div class="form-group">
       <label for="user" class="col-md-3 control-label">User:</label>   
        <textarea>${projectAssignment.assignedName}</textarea> 
        </div> 
        
         <div class="form-group">
       <label for="comments" class="col-md-3 control-label">comments</label>
       <div class="col-md-9">
        <form:input path="comments" cssClass="form-control" />
       </div>
      </div>
        
      

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>