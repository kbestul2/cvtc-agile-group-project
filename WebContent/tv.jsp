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
				<!-- Output the series list -->
				<c:choose>
					<c:when test="${empty series}">
						<p>Sorry, the list of series is empty.</p>
					</c:when>
					<c:otherwise>
						<c:forEach var="series" items="${series}">
							<h2>${series.name}</h2>
							<p>
								Title: ${series.name}<br>
								Original Release: ${series.releaseDate}<br>
								Stream Release: ${series.streamDate}<br>
								Rating: ${series.ratingText}<br>
								Length: ${series.length} minutes<br>
								Description: ${series.description}<br>
								Rating: ${series.ratingNumber}<br>
								coverImgUrl: ${series.coverImgUrl}<br>
								trailerUrl: ${series.trailerUrl}
							</p>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>			
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
</html>