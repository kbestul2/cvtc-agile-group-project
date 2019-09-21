<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Movies List</title>
<meta name="description" content="This is a JSP example that demonstrates how to output
every Movie in my Excel spreadsheet to a web page">
<%@ include file="assets/includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Movie List</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div class="container">
			<!-- Output the movie list -->
			<c:choose>
				<c:when test="${empty movies}">
					<p>Sorry, the list of movies is empty.</p>
				</c:when>
				<c:otherwise>
					<c:forEach var="movie" items="${movies}">
						<h2>${movie.name}</h2>
						<p>
							${movie.name} is ${movie.length} minutes long.
							<br>Original Release: ${movie.releaseDate}
							<br>Stream Release: ${movie.streamDate}
						</p>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		<hr>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>