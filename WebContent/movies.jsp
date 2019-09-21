<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine Movies</title>
		<%@ include file="assets/includes/styles.jsp" %>
	</head>
	<body>
		<div id="wrapper">
			<h1>Movies</h1>
			<%@ include file="assets/includes/nav.jsp" %>
			<div id="mainContent">
				<!-- Output the movie list -->
				<c:choose>
					<c:when test="${empty movies}">
						<p>Sorry, the list of movies is empty.</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="movie" items="${movies}">
							<h2>${movie.name}</h2>
							<p>
								Title: ${movie.name}<br>
								Original Release: ${movie.releaseDate}<br>
								Stream Release: ${movie.streamDate}<br>
								Rating: ${movie.ratingText}<br>
								Length: ${movie.length} minutes<br>
								Description: ${movie.description}<br>
								Rating: ${movie.ratingNumber}<br>
								coverImgUrl: ${movie.coverImgUrl}<br>
								trailerUrl: ${movie.trailerUrl}
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
</html>