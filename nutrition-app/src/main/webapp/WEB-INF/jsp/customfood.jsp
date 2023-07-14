<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Custom Food</title>
</head>
<body>
<form:form method="POST" action="foodservice" commandName="nutritionmodel">
<table>
 <tr>
 <td><form:label path="food_id">Food_id</form:label></td>
 <td><form:input path="food_id"/></td>
 </tr>
 <tr>
 <td><form:label path="food_name">Food_name</form:label></td>
    <td><form:input path="food_name"/></td>
 </tr>
 <tr>
  <td><form:label path="food_quantity">Food_quantity</form:label></td>
    <td><form:input path="food_quantity"/></td>
 </tr>
 <tr>
   <td><form:label path="food_calories">Food_calories</form:label></td>
   <td><form:input path="food_calories"/></td>
 </tr>
 <tr>
 <td><input type="submit" value="save"/></td>
 </tr>
</table>
</form:form>

</body>
</html>