<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="black">
                

  <form:form action="forgotPw" method="POST" modelAttribute="forgotPass">
  
   <h1 style="color:white;text-align:center">Forgot Password Page</h1>
   
            <h1 style="color:green ;text-align:center">${result}</h1> <br> 
                          
      <table align="center" bgColor="green" border="12" style="border-color:blue">
        <tr>
       <td>Enter Email ID :: </td>
       <td>
       <form:input path="email"/></td>
        </tr>
        <tr>
        <td colspan="1" align="center" bgcolor="lightgreen"><b><input type="submit" value="Submit" color="blue"/></b></td>&nbsp;&nbsp;&nbsp;&nbsp;
       <td align="center" bgcolor="lightgreen"><b><a href="login">Login</a></b></td>
        </tr>
        
        <tr>
        
        </tr>
        
        
      </table>
  
  
  </form:form>
  




</body>
</html>