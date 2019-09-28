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
		<div class = "searchDiv">
				<form class= "search"action = "Search" method = "post">
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
							<h2>${music.name}</h2>
							<p>
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
	<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Maven Pro' rel='stylesheet'>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</html>