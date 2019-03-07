<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">  
 
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
 

<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function() {
		
			$.ajax({
				url : 'FindMovieServlet',
				type: 'POST',
				success : function(responseText) {
					var value=responseText.split(',');
					
					for(var item in value)
						{
						
							$('#combo').append("<option value="+value[item]+">"+value[item]);
						}
					console.log(responseText);
					$('#ajaxGetUserServletResponse').text(responseText);
				}
			});
		});
	
</script>
</head>
<body>


  <form method="post" action="AddCastServlet">

	


	
		<table>
			<tr>
			<td colspan="2"><h3>ADD CAST DETAIL</h3></td>
			</tr>
			<tr>
				
		<td>	<select name="moviename" id="combo">
		<option value="-1">Select
		</option>
			</select></td>
				
			</tr>
			<tr>
				<td><input type="text" name="castname"></td>
			</tr>
			<tr>
			<td>
			<input type="text" name="castrole">
					
			</td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">ADD</button></td>
			
			</tr>
			
		</table>
</form>
</body>
</html>
