<!DOCTYPE html>
<html>
<head>
<title>Movies: Populate Database</title>
<%@ include file="assets/includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Populate Database</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div class="container">
			<form action="PopulateDatabase" method="post">
				<p>Click on the populate button to populate the movie database.</p>
				<p>Warning: Submitting this form will reset the database and it will only contain the movies in the original spreadsheet!</p>
				<input type="submit" value="Populate!">
			</form>
		</div>
		<hr>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>