<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1" isELIgnored = "false"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 

<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
    <title>Food Track</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<body>
<form action="searchfood" id="searchform">
	<!-- <input name="item1" type="search"> -->
	<input name="fooditem" list="datalistOptions" id="foodname" placeholder="Search Food Database">
	<datalist id="datalistOptions">
	</datalist>
</form>

<script>
function delay(callback, ms) {
	var timer = 0;
	return function() {
	    var context = this, args = arguments;
	    clearTimeout(timer);
	    timer = setTimeout(function () {
	      callback.apply(context, args);
	    }, ms || 0);
    };
}

$('#foodname').keyup(delay(function (e) {
	searchViaAjax(this.value);
	//console.log('Time elapsed!', this.value);
 },0));
function searchViaAjax(searchText) {
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "foodnamelist",
		data: {
			foodName: searchText
	    },
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			$('#datalistOptions').empty();
			$.each(data, function (i, item) {
			    $('#datalistOptions').append($('<option>', { 
			    	value: item,
			        text : item
			    }));
			});
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			// display(e);
		}
	});
}

</script>
</body>
</html>