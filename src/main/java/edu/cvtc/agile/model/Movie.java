package edu.cvtc.agile.model;

import java.io.Serializable;
import java.sql.Date;

public class Movie extends Content implements Serializable {

	private static final long serialVersionUID = 6763824524233477194L;
	
	private String title;
	private Date releaseDate;
	private Date streamDate;
	private String contentRating;
	private int length;
	private String description;
	private float userRating;
	private String coverImgUrl;
	private String trailerUrl;
	private String platform;
	
	public Movie(String title, Date releaseDate, Date streamDate, String contentRating, int length,
			String description, float userRating, String coverImgUrl, String trailerUrl, String platform) {
		this.title = title;
		this.releaseDate = releaseDate;
		this.streamDate = streamDate;
		this.contentRating = contentRating;
		this.length = length;
		this.description = description;
		this.userRating = userRating;
		this.coverImgUrl = coverImgUrl;
		this.trailerUrl = trailerUrl;
		this.platform = platform;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getStreamDate() {
		return streamDate;
	}

	public void setStreamDate(Date streamDate) {
		this.streamDate = streamDate;
	}

	public String getContentRating() {
		return contentRating;
	}

	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getUserRating() {
		return userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	public String getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate + ", streamDate=" + streamDate
				+ ", contentRating=" + contentRating + ", length=" + length + ", description=" + description
				+ ", userRating=" + userRating + ", coverImgUrl=" + coverImgUrl + ", trailerUrl=" + trailerUrl
				+ ", platform=" + platform + "]";
	}
	
}
