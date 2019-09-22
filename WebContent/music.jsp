<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine Music</title>
		<%@ include file="assets/includes/styles.jsp" %>
	</head>
	<body>
		<div id="wrapper">
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
							<h2>${music.name}</h2>
							<p>
								Title: ${music.name}<br>
								Original Release: ${music.releaseDate}<br>
								Stream Release: ${music.streamDate}<br>
								Artist: ${music.artist}<br>
								Length: ${music.lengthInMinutes} minutes (${music.lengthInSeconds} seconds)<br>
								Rating: ${music.rating}<br>
								coverImgUrl: ${music.coverImgUrl}<br>
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
</html>