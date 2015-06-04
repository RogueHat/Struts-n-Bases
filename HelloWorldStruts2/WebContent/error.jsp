<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<title>Get States by Population</title>
</head>
<body>
	<form action="searchaction" method="post">
		<br />
			<label for=slider>Population</label> 
			<input 
				type=range min=0 max=10000000 id=slider 
				step=100000 oninput="outputUpdate(value)" name ="population">
			<output for=slider id=val>5000000</output>
		
<!-- 			JavaScript to output slider value -->
			<script>
				function outputUpdate(pop) {
					document.querySelector('#val').value = pop;
				}
			</script>
	
			<input type="submit" value="Submit" />
		<br />
		
		<br />
			No States
		<br />
	</form>
</body>
</html>