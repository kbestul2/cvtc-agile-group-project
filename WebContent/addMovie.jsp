<!DOCTYPE html>
<html>
<head>
<title>Movies: Add New Movie</title>
<%@ include file='assets/includes/styles.jsp' %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Add Movie</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div class="container">
			<form action="AddMovie" method="post">
				<label for="title"><strong>Title:</strong></label>
				<input name="title"><br><br>
				
				<label for="director"><strong>Director:</strong></label>
				<input name="director"><br><br>
				
				<label for="length"><strong>Length in Minutes:</strong></label>
				<input name="length"><br><br>
				
				<label for="genre"><strong>Genre(s):</strong></label>
				<input name="genre"><br><br>
				
				<input type="submit" value="Add Movie">
			</form>
		</div>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>