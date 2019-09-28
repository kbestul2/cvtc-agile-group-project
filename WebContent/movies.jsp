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
				<form class = "search" action = "Search" method = "post">
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
								Content Rating: ${movie.contentRating}<br>
								Length: ${movie.length} minutes<br>
								Description: ${movie.description}<br>
								User Rating: ${movie.userRating}<br>
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
	<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Maven Pro' rel='stylesheet'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</html>