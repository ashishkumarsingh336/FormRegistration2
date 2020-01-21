<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="gray">
      
      <font face = "Comic sans MS" size =" 6" color="#006400">  ${sMsg}</font><br>
      <font face = "Comic sans MS" size =" 6" color="red">  ${sMsg1}</font>
     
        
  <form:form action="saveRecord" method="POST" modelAttribute="userRegistration">
  
   <h1 style="color:white;text-align:center">Registration Form Page</h1>
      <table align="center" bgColor="violet" border="12" style="border-color:blue">
        <tr>
        <td><b><font size="4">First Name :</font></b></td><td width="150"><form:input path="fName"/></td>
        </tr>
        <tr>
        <td><b><font size="4">Last Name :</font></b></td><td><form:input path="lName"/></td>
        </tr>
        <tr>
        <td><b><font size="4">Email ID :</font></b></td><td width="150"><form:input path="email" id="validEmail"/>
                                                         <div id="dupEmail" style="color:red"></div>
        </td>
        </tr>
        <tr>
        <td><b><font size="4">Phone Number :</font></b></td><td width="150"><form:input path="phNo"/></td>
        </tr>
        <tr>
        <td><b><font size="4">Date Of Birth :</font></b></td><td width="150"><form:input path="dob"/></td>
        </tr>
        <tr>
        <td><b><font size="4">Gender :</font></b></td> <td> <form:input path="gender"/></td>
        </tr>
        <tr>
        <td><b><font size="4">City :</font></b></td><td width="150"><form:input path="city"/></td>
        </tr>
        <tr>
        <td><b><font size="4">State :</font></b></td><td width="150"><form:input path="state"/></td>
        </tr>
        <tr>
        <td><b><font size="4">Country :</font></b></td><td width="150"><form:input path="country"/></td>
        </tr>
        
        <tr>
        <td colspan="2" align="center" bgcolor="lightgreen"><b><input type="submit" value="Submit" color="blue"/></a></b></td>
        
        </tr>

      </table>
  
  
  </form:form>
  




</body>
</html>