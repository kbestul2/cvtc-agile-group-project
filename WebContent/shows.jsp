<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine TV</title>
		<%@ include file="assets/includes/styles.jsp" %>
		<link href='assets/css/content.css' rel='stylesheet'>
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
							<div class="content">
								<h2>${show.title}</h2>
								<div class = "imageContainer">
									<a href="${show.trailerUrl}" target="_blank"><img src="${show.coverImgUrl}" class="contentImage"></a>
								</div>
								<ul class="contentList">
									<li><span>Original Release: </span>${show.releaseDate}</li>
									<li><span>Stream Release: </span>${show.streamDate}</li>
									<li><span>Content Rating: </span>${show.contentRating}</li>
									<c:if test="${show.season ne -1}">
										<li>
											<span>Season: </span>${show.season}
											<c:if test="${show.episodes ne -1}">
												<span>&nbsp; Episodes: </span>${show.episodes}
											</c:if>
										</li>
									</c:if>
									<li class="description"><span>Description: </span>${show.description}</li>
									<li class="genres"><span>Genres: </span>${show.genres}</li>
									<c:if test="${show.userRating ne -1}">
										<li><span>User Rating: </span>${show.userRating}</li>
									</c:if>
									<li><span>platform: </span>${show.platform}</li>
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