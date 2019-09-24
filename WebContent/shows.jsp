<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine TV</title>
		<%@ include file="assets/includes/styles.jsp" %>
	</head>
	<body>
		<div id="wrapper">
			<h1>TV</h1>
			<%@ include file="assets/includes/nav.jsp" %>
			<div id="mainContent">
				<!-- Output the shows list -->
				<c:choose>
					<c:when test="${empty shows}">
						<p>Sorry, the list of shows is empty.</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="show" items="${shows}">
							<h2>${show.title}</h2>
							<p>
								Original Release: ${show.releaseDate}<br>
								Stream Release: ${show.streamDate}<br>
								Content Rating: ${show.contentRating}<br>
								Season: ${show.season}<br>
								Episodes: ${show.episodes}<br>
								Description: ${show.description}<br>
								User Rating: ${show.userRating}<br>
								coverImgUrl: ${show.coverImgUrl}<br>
								trailerUrl: ${show.trailerUrl}<br>
								platform: ${show.platform}
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>			
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
</html>