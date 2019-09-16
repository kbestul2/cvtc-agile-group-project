<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Movies: Error</title>
<%@ include file="assets/includes/styles.jsp" %>
</head>
<body>
	<div class="container">
		<div class="hero-unit">
			<h1>Error!</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div class="container">
			<p>Houston, we've had a problem.</p>
			<c:choose>
				<c:when test="${message != null}">
					<p>${message}</p>
				</c:when>
				<c:otherwise>
					<p>To continue, click the Back button</p>
					<p><strong>Error Details</strong></p>
					<p>Type: ${pageContext.exception["class"]}</p>
					<p>Message: ${pageContext.exception.message}</p>
				</c:otherwise>
			</c:choose>
		</div>
		<hr>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>