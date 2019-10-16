<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
     "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Contact: Result</title>
<%@ include file="assets/includes/styles.jsp" %>
</head>
<body>
	<div id="wrapper">
		<div class="hero-unit">
			<h1>Contact Us</h1>
		</div>
		<%@ include file="assets/includes/nav.jsp" %>
		<div id="mainContent">
			<div class="container">
				<p><%=request.getAttribute("Message")%></p>
			</div>
		</div>
		<hr>
		<%@ include file="assets/includes/footer.jsp" %>
	</div>
	<%@ include file="assets/includes/scripts.jsp" %>
</body>
</html>