<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form:form commandName="food" action="foodservice">
 <table>
 <tr>
 <td>FoodName:</td>
 <td><input name="foodname" type="text" placeholder="Food Name"/></td>
 </tr>
 <tr>
 <td>FoodQuantity:</td>
 <td><input name="quantity" type="text" placeholder="Quantity"/></td>
 </tr>
 <tr>
 <td>Serving Size:</td>
 <td><input name="servingsize" type="text" placeholder="serving unit"></td>
 </tr>
 <tr>
 <td>FoodCalories:</td>
 <td><input name="calories" type="text"/></td>
 </tr>
 <tr>
 <td><input type="submit" value="save"/></td>
 </tr>
 </table>
 </form:form>
</body>
</html>