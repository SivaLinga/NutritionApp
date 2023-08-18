<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Food</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/units-converter@1.0.3/dist/umd/index.min.js"></script>
<body>
<form action="customfood">
 <h4>${fooddao.foodname}</h4>
<input type="number" value="${fooddao.quantity}" id="newQuantity" oninput="calculate()">
  <select name="unit" id="units" onchange="weightconverter(this.value)">
    <option value="g">grams</option>
    <option value="lb">lb</option>
    <option value="kg">kg</option>
    <option value="oz">wt.oz</option>
  </select><br>
  <input value="${fooddao.calories}" id="calories"> Calories
<br><input type="submit" value="Add to food log">
</form>
<c:set var="foodDaoQuantity" value="${fooddao.quantity}"/>
<c:set var="foodDaoCalories" value="${fooddao.calories}"/>
<script>
function calculate()
{
	var fooddaoquantity="<c:out value='${foodDaoQuantity}' />";
	newQuantity= document.getElementById("newQuantity").value;
    var fooddaocalories="<c:out value='${foodDaoCalories}' />"
    var unit=document.getElementById("units").value;
    /* console.log(unit); */
    var convertedQtyInGr=converter.mass(newQuantity).from(unit).to('g').value;
    /* console.log(convertedQtyInGr); */
    var newcalories=(fooddaocalories*convertedQtyInGr)/fooddaoquantity;
    document.getElementById("calories").value = newcalories;
} 
function weightconverter(valnum){
	var fooddaoquantity="<c:out value='${foodDaoQuantity}' />";
	var fooddaocalories="<c:out value='${foodDaoCalories}' />";
	var convertedQtyInGr = converter.mass(document.getElementById("newQuantity").value).from(valnum).to('g').value;
	/* console.log(convertedQtyInGr); */
	var newcalories=(fooddaocalories*convertedQtyInGr)/fooddaoquantity;
	/* console.log(newcalories); */
	document.getElementById("calories").value = newcalories;
}
</script>
</body>
</html>