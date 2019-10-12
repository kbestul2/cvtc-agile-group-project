<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>streamLine</title>
		<%@ include file="assets/includes/styles.jsp" %>
	</head>
	<body>
		<div id="wrapper">
			<h1>stream<span id="accent">LINE</span></h1>
			<%@ include file="assets/includes/nav.jsp" %>
			 <h2 id= "featHead">Featured</h2> 
			<h3>October<span id="year">2019</span></h3>
			<div id="featureMainContent">
				<div id="featureRotator">
					<div class="featureContent">
						<a href="https://www.amazon.com/Modern-Love-Season-1/dp/B07VNF5351" target="_blank">
						<img src="assets/images/AmazonFeatured.jpg" alt="Amazon Featured">
						</a>
					</div>
					<div class="featureContent">
						<a href= "https://www.hulu.com/series/castle-rock-b11816c9-9e35-
						44f3-bf04-220b1d12f770?&cmp=8131&utm_source=google&utm_medium=SEM&utm
						_campaign=Content%20Marketing%20Search%20Castle%20Rock&utm_term=+castle%20+
						rock%20+season%20+2&ds_rl=1251123&gclid=EAIaIQobChMI_ub60OOS5QIVj6DsCh1CuAksEAAYASAAEgIqJvD_BwE&gclsrc=aw.ds" 
						target="_blank">
						<img src="assets/images/HuluFeatured.jpg" alt="Hulu Featured">
						</a>
					</div>
					<div class="featureContent">
						<a href="https://www.netflix.com/title/80117803" target="_blank">
						<img src="assets/images/NetflixFeatured.jpg" alt="Netflix Featured">
						</a>
					</div>
					<div class="featureContent">
						<a href="https://soundcloud.com/halfnoisemusic/albums" target="_blank">
						<img src="assets/images/SoundcloudFeatured.jpg" alt="Soundcloud Featured">
						</a>
					</div>
					<div class="featureContent">
						<a href="https://open.spotify.com/album/1JaCRg0kiQCxm2jxIby648" target="_blank">
						<img src="assets/images/SpotifyFeatured.jpg" alt="Spotify Featured">
						</a>
					</div>
				</div>
			</div>
			<div id="platforms">
				<a href= "https://www.amazon.com/Prime-Video/b?ie=UTF8&node=2676882011" target="_blank">
				<img id="amazon" src="assets/images/Amazon.png">
				</a>
				<a href="https://www.hulu.com/welcome" target="_blank">
				<img id="hulu" src="assets/images/hulu.png">
				</a>
				<a href="https://www.netflix.com" target="_blank">
				<img id="netflix" src="assets/images/Netflix.png">
				</a>
				<a href="https://soundcloud.com" target="_blank">
				<img id="soundcloud" src="assets/images/Soundcloud.png">
				</a>
				<a href="https://www.spotify.com/us/" target="_blank">
				<img id="spotify" src="assets/images/Spotify.png">
				</a>
				
			</div>
			<%@ include file="assets/includes/footer.jsp" %>
		</div>
		<script   src="https://code.jquery.com/jquery-3.3.1.min.js"   integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="   crossorigin="anonymous"></script>
		<script src="assets/js/jquery.rotator.js"></script>
		<script>
			$( function() {
				/*
				- how to call the plugin:
				$( selector ).qtRotator( [options] );
				- options:
				{
					// default transition speed (ms)
					speed : 700,
	         
					// default transition easing
					easing : 'ease',
					// rotator interval (ms)
					interval : 8000
				}
				- destroy:
				$( selector ).qtRotator( 'destroy' );
				*/
		        $('#featureRotator').ftRotator({
		          speed: 600,
		          interval: 4000,
		        });
				
			} );
		</script>
	</body>
	<link href='https://fonts.googleapis.com/css?family=Audiowide' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Jura' rel='stylesheet'>
	<link href='https://fonts.googleapis.com/css?family=Maven Pro' rel='stylesheet'>
</html>