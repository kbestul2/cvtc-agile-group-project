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
		<div class = "searchDiv">
				<form class = "search" action = "ShowSearch" method = "post">
					<label for= "shows"><strong>Search Shows:</strong></label>
					<input name="shows">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
				</div>
			<h1>Shows</h1>
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
	<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Maven Pro' rel='stylesheet'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</html>