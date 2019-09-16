<!DOCTYPE html>
<html>
<head>
<title>Movies: Search</title>
<%@ include file="assets/includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Search</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div class="container">
			<form action="Search" method="post">
				<label for="title"><strong>Search by title:</strong></label>
				<input name="title">
				<input type="submit" value="Search!" name="titleSearch">
			</form>
			<form action="Search" method="post">
				<label for="director"><strong>Search by director:</strong></label>
				<input name="director">
				<input type="submit" value="Search!" name="directorSearch">
			</form>
		</div>
		<hr>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>