<!DOCTYPE html>
<html>
<head>
<title>Movies: Success</title>
<%@ include file="assets/includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Success!</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div class="container">
			<p>${message}</p>
		</div>
		<hr>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>