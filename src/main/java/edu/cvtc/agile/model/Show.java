package edu.cvtc.agile.model;

import java.io.Serializable;
import java.sql.Date;

public class Show extends Content implements Serializable {
	
	private static final long serialVersionUID = -6851644762029925697L;
	
	private String name;
	private Date releaseDate;
	private Date streamDate;
	private String ratingText;
	private String description;
	private float ratingNumber;
	private String coverImgUrl;
	private String trailerUrl;
	
	public Show(String name, Date releaseDate, Date streamDate, String ratingText, String description,
			float ratingNumber, String coverImgUrl, String trailerUrl) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.streamDate = streamDate;
		this.ratingText = ratingText;
		this.description = description;
		this.ratingNumber = ratingNumber;
		this.coverImgUrl = coverImgUrl;
		this.trailerUrl = trailerUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getRatingText() {
		return ratingText;
	}

	public void setRatingText(String ratingText) {
		this.ratingText = ratingText;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getRatingNumber() {
		return ratingNumber;
	}

	public void setRatingNumber(float ratingNumber) {
		this.ratingNumber = ratingNumber;
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

	@Override
	public String toString() {
		return "Series [name=" + name + ", releaseDate=" + releaseDate + ", streamDate=" + streamDate + ", ratingText="
				+ ratingText + ", description=" + description + ", ratingNumber=" + ratingNumber
				+ ", coverImgUrl=" + coverImgUrl + ", trailerUrl=" + trailerUrl + "]";
	}
	
}