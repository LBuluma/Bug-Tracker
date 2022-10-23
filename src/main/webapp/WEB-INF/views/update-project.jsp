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
   <h2 class="text-center">Project</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Update Project</div>
    </div>
    <div class="panel-body">
     <form:form action="updateProject" cssClass="form-horizontal"
      method="post" modelAttribute="project">

      <!-- need to associate this data with project id -->
      <form:hidden path="projectId" />
      
      <form:hidden path="createdBy" />
      
      <form:hidden path="createdDate" />
      
       <form:hidden path="ownerId" />
       
   
      
    

      <div class="form-group">
       <label for="projectname" class="col-md-3 control-label">Project  Name</label>
       <div class="col-md-9">
        <form:input path="projectName" cssClass="form-control" />
       </div>
      </div>
      
       <div class="form-group">
       <label for="projectname" class="col-md-3 control-label">Owner  Name</label>
       <div class="col-md-9">
        <input value="${project.ownerName}"  readonly/>
       </div>
      </div>
      <div class="form-group">
       <label for="startdate" class="col-md-3 control-label">Start Date</label>
       <div class="col-md-9">
        <form:input path="startDate" cssClass="form-control"  type="date"/>
       </div>
      </div>
      <div class="form-group">
       <label for="enddate" class="col-md-3 control-label" >End Date</label>
       <div class="col-md-9">
        <form:input path="endDate" cssClass="form-control" type="date"/>
       </div>
      </div>
         <div class="form-group">
       <label for="description" class="col-md-3 control-label">Project Description</label>
       <div class="col-md-9">
        <form:textarea path="description" cssClass="form-control" />
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