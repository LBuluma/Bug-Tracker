<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bug Tracker</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"></script>


</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>CRM - User Relationship Manager</h2>
   <hr />

   <input type="button" value="Add User"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">User List</div>
    </div>
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       
       <!--<th>#</th> -->     
       <th>First Name</th>
       <th>Second Name</th>
       <th>Active</th>      
       <th>Created By</th>
       <th>Created Date</th>
       <th>Updated By</th>
       <th>Update Date</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempUser" items="${users}">
   

      <!-- construct an "update" link with customer id -->
      
       <c:url var="updateLink" value="/updateForm">
        <c:param name="userId" value="${tempUser.userId}" />
       </c:url>


       <!-- construct an "delete" link with customer id -->
       <!-- 
       <c:url var="deleteLink" value="/customer/delete">
        <c:param name="customerId" value="${tempCustomer.id}" />
       </c:url>-->

       <tr>
        <td>${tempUser.firstName}</td>
         <td>${tempUser.secondName}</td>
         <td>${tempUser.activeFlag}</td>
         <td>${tempUser.createdBy}</td>
        <td>${tempUser.createdDate}</td>
        <td>${tempUser.updatedBy}</td>
        <td>${tempUser.updatedDate}</td>
       

          <td>
         <!-- display the update link -->
         <a href="${updateLink}" onclick="if (!(confirm('Are you sure you want to update this customer?'))) return false">Update</a>
         | 
        </td>

       </tr>

      </c:forEach>

     </table>

    </div>
   </div>
  </div>

 </div>
</body>
</html>