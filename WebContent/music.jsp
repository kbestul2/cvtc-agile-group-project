<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine Music</title>
		<%@ include file="assets/includes/styles.jsp" %>
		<link href='assets/css/content.css' rel='stylesheet'>
	</head>
	<body>
		<div id="wrapper">
			<div class = "searchDiv">
				<form class= "search"action = "MusicSearch" method = "post">
					<label for= "music"><strong>Search Music:</strong></label>
					<input name="music">
					<button type="submit"><i class="fa fa-search"></i></button>
				</form>
			</div>
			<h1>Music</h1>
			<%@ include file="assets/includes/nav.jsp" %>
			<div id="mainContent">
				<!-- Output the music list -->
				<c:choose>
					<c:when test="${empty music}">
						<p>Sorry, the list of music is empty.</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="music" items="${music}">
							<div class="content">
								<h2>${music.title}</h2>
								<div class = "imageContainer">
									<img src="${music.coverImgUrl}" class="contentImage">
								</div>
								<ul class="contentList">
									<li><span>Artist: </span>${music.artist}</li>
									<li><span>Release: </span>${music.releaseDate}</li>
									<li class="genres"><span>Genres: </span>${music.genres}</li>
									<li><span>Content Warning: </span>${music.contentWarning}</li>
									<c:if test="${music.userRating ne -1}">
										<li><span>User Rating: </span>${music.userRating}</li>
									</c:if>
									<li><span>Length: </span>${music.lengthMS}</li>
									<li><span>Record Label: </span>${music.recordLabel}</li>
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