<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BUG TRACKER</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>

</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">USERS</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add user</div>
    </div>
    <div class="panel-body">
     <form:form action="saveUser" cssClass="form-horizontal"
      method="post" modelAttribute="user">

      <!-- need to associate this data with customer id -->
      <form:hidden path="userId" />

      <div class="form-group">
       <label for="userName" class="col-md-3 control-label">
        Name</label>
       <div class="col-md-9">
        <form:input path="userName" cssClass="form-control" />
       </div>
       
  
       
      </div>

  
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      

     </form:form>
      </div>
    </div>
   </div>
  </div>
</body>
</html>