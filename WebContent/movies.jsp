<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine Movies</title>
		<%@ include file="assets/includes/styles.jsp" %>
		<link href='assets/css/content.css' rel='stylesheet'>
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
							<div class="content">
								<h2>${movie.title}</h2>
								<div class = "imageContainer">
									<a href="${movie.trailerUrl}" target="_blank"><img src="${movie.coverImgUrl}" class="contentImage"></a>
								</div>
								<ul class="contentList">
									<li><span>Original Release: </span>${movie.releaseDate}</li>
									<li><span>Stream Release: </span>${movie.streamDate}</li>
									<li class="description"><span>Description: </span>${movie.description}</li>
									<li class="genres"><span>Genres: </span>${movie.genres}</li>
									<li><span>Content Rating: </span>${movie.contentRating}</li>
									<c:if test="${movie.userRating ne -1}">
										<li><span>User Rating: </span>${movie.userRating}</li>
									</c:if>
									<li><span>Length: </span>${movie.length} minutes</li>
									<li><span>platform: </span>${movie.platform}</li>
								</ul>
							</div>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
</html>