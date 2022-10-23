<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BUG TRACKER</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">USER</h2>
   <div class="panel panel-info">
   
    <div class="panel-body">
     <form:form action="updateUser" cssClass="form-horizontal"
      method="post" modelAttribute="user">
     
        

      <div class="form-group">
       <label for="firstname" class="col-md-3 control-label">First
        Name</label>
       <div class="col-md-9">
        <form:input path="firstName" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="lastname" class="col-md-3 control-label">Last
        Name</label>
       <div class="col-md-9">
        <form:input path="secondName" cssClass="form-control" />
       </div>
      </div>
      
      <div class="form-group">
       <label for="email" class="col-md-3 control-label">Email</label>
       <div class="col-md-9">
        <form:input path="email" cssClass="form-control" type="email"/>
       </div>
      </div>
      
      <div class="form-group">
       <label for="activeFlag" class="col-md-3 control-label">Active</label>
       <div class="col-md-9">
        <form:input path="activeFlag" cssClass="form-control" type="text"/>
       </div>
      </div>
      
      
       <div class="form-group">
       <label for="role" class="col-md-3 control-label">Role</label>
       <div class="col-md-9">     
       
        <form:select path="roleId">
        <c:forEach var="userRoles" items="${userRoles}">
           <form:option value="${userRoles.roleId}" label="${userRoles.roleName}" />
            </c:forEach>
        </form:select> 
        
        <!-- need to associate this data with customer id -->
      <form:hidden path="createdDate" /> 
      
      
      <!-- need to associate this data with customer id -->
      <form:hidden path="createdBy" />

      <!-- need to associate this data with customer id -->
      <form:hidden path="userId" />  
        
       </div>
      </div>
     

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary"  onclick="if (!(confirm('Are you sure you want to update this user?'))) return false">Submit</form:button>
       </div>
      </div>

     </form:form>
     
     
    </div>
   </div>
  </div>
 </div>
</body>
</html>