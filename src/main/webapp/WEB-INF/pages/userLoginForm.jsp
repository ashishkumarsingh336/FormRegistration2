<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
                      

  <form:form action="loginAccount" method="POST" modelAttribute="login">
  
   <h1 style="color:white;text-align:center">Home Page</h1>
            
            <h1 style="color:green ;text-align:center">${string}</h1> <br> 
                          
      <table align="center" bgColor="green" border="12" style="border-color:blue">
        <tr>
       <td>Enter Email ID :: </td>
       <td>
       <form:input path="email"/></td>
        </tr>
        <tr>
        <td><b><font size="4">Password:</font></b></td><td width="150"><form:input path="pazzword" /></td>
        </tr>
        
        <tr>
        <td colspan="2" align="center" bgcolor="lightgreen"><b><input type="submit" value="SignIn" color="blue"/></b></td>
        </tr>
        
        <tr>
        <td  align="center" bgcolor="lightgreen"><b><a href="forgotPwd">Forget Password</a></b></td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <td align="center" bgcolor="lightgreen"><b><a href="signup">SignUp</a></b></td>
        </tr>
        
        
      </table>
            <a href="dashBoard"><font size="6">Welcome to DashBoard</font></a>
  
  </form:form>
  




</body>
</html>