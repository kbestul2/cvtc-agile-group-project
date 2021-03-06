# streamLINE
Group project for Agile Programming with Design Patterns  
  
To submit changes:  
-Download and install Git, using GitHub credentials  
-Open Git Bash and navigate to directory where you want the project stored  
-Type: $ git clone https://github.com/kbestul2/cvtc-agile-group-project.git  
-If repository already exists on your computer, type: $ git pull  
-Make changes to the project  
-Type: $ git add .  
-Type: $ git merge  
-Resolve any merge conflicts by picking and choosing which code should be kept  
-Type: $ git commit  
-Type a short message summarizing your changes, then save and close the text editor  
-Type: $ git push  
  
*Note: NEVER do "$ git push -f" when push is not working.  
  
To fix servlet-api.jar errors:  
-Right click on the top-level project folder in the project explorer  
-Click "properties"  
-Go to "Java Build Path"  
-Go to the "Libraries" tab  
-Select "servlet-api.jar" and click the "Edit" button  
-Navigate to the servlet-api.jar in your TomCat server installation (apache-tomcat-9.0.0.M26\lib)  
-Click Apply  
  
*Note: You may need to do something similar for the Maven Dependencies and the JRE System Library (jdk1.8.0_221)  


# Database Queries

Each query will be typed out for each included field instead of using * for clarity.

## Movies

```
SELECT MovieID, 
   	Title, 
	ReleaseDate, 
	StreamDate, 
	Length, 
	Description, 
	UserRating, 
	CoverImgUrl, 
	TrailerKey, 
	Platform, 
	r.Rating AS ContentRating, 
	GROUP_CONCAT(g.Name SEPARATOR ', ') AS Genre
FROM movies m
	INNER JOIN ratings r USING (RatingID)
	INNER JOIN movie_genre mg USING (MovieID)
	INNER JOIN genres g USING (GenreID)
GROUP BY m.MovieID
```

## Shows

```
SELECT ShowID,
	s.Name,
    ReleaseDate,
    StreamDate,
    Season,
    Episodes,
    Description,
    s.Rating,
    CoverImgUrl,
    TrailerKey,
    Platform,
	r.Rating AS ContentRating, 
	GROUP_CONCAT(g.Name SEPARATOR ', ') AS Genre
FROM shows s
	INNER JOIN ratings r USING (RatingID)
	INNER JOIN show_genre mg USING (ShowID)
	INNER JOIN genres g USING (GenreID)
GROUP BY s.ShowID
```

## Music

Explicit is ageRating in the form of a int-based boolean, 0 = false, 1 = true

```
SELECT AlbumID,
	Album,
    Artist,
    ReleaseDate,
    RecordLabel,
    Explicit,
    Rating,
    CoverImgUrl,
	group_concat(g.Name SEPARATOR ', ') AS Genre
FROM music m
	INNER JOIN album_genre AS ag USING (AlbumID)
  INNER JOIN genres AS g USING (GenreID)
GROUP BY m.AlbumID
```


