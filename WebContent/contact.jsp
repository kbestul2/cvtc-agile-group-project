<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine Contact</title>
		<%@ include file="assets/includes/styles.jsp" %>
		<link href='assets/css/contactForm.css' rel='stylesheet'>
	</head>
	<body>
		<div id="wrapper">
			<h1>Contact Us</h1>
			<%@ include file="assets/includes/nav.jsp" %>
			<div id="mainContent">
				<div id="contactContent">
					<p>
						Reach out today!<br>
						(715) 123-4567<br>
						streamLineGroup@cvtc.edu
					</p>
					<br>
					<form>      
						<input name="name" type="text" class="feedbackText" placeholder="Name" />   
						<input name="email" type="text" class="feedbackText" placeholder="Email" />
						<textarea name="text" class="feedbackText" placeholder="Comment"></textarea>
						<input id="submit" type="submit" value="SUBMIT"/>
					</form>
				</div>
			</div>
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
	</body>
	<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Maven Pro' rel='stylesheet'>
</html>