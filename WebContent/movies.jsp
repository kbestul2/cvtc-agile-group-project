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
		<div class = "searchDiv">
				<form class = "search" action = "MovieSearch" method = "post">
					<label for= "movies"><strong>Search Movies:</strong></label>
					<input name="movies">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
				</div>
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
							<h2>${movie.title}</h2>
							<p>
								Original Release: ${movie.releaseDate}<br>
								Stream Release: ${movie.streamDate}<br>
								Description: ${movie.description}<br>
								Genres: ${movie.genres}<br>
								Content Rating: ${movie.contentRating}<br>
								User Rating: ${movie.userRating}<br>
								Length: ${movie.length} minutes<br>
								coverImgUrl: ${movie.coverImgUrl}<br>
								trailerUrl: ${movie.trailerUrl}<br>
								platform: ${movie.platform}
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
</html>