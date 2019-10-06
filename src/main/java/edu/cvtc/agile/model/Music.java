package edu.cvtc.agile.model;

import java.io.Serializable;
import java.sql.Date;

public class Music extends Content implements Serializable {

	private static final long serialVersionUID = 3605785336363110316L;

	private String title;
	private String artist;
	private Date releaseDate;
	private Date streamDate;
	private String genres;
	private String contentWarning;
	private float userRating;
	private int lengthMS;
	private String recordLabel;
	private String coverImgUrl;
	
	public Music(String title, String artist, Date releaseDate, Date streamDate, String genres, String contentWarning,
			float userRating, int lengthMS, String recordLabel, String coverImgUrl) {
		super();
		this.title = title;
		this.artist = artist;
		this.releaseDate = releaseDate;
		this.streamDate = streamDate;
		this.genres = genres;
		this.contentWarning = contentWarning;
		this.userRating = userRating;
		this.lengthMS = lengthMS;
		this.recordLabel = recordLabel;
		this.coverImgUrl = coverImgUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
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

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getContentWarning() {
		return contentWarning;
	}

	public void setContentWarning(String contentWarning) {
		this.contentWarning = contentWarning;
	}

	public float getUserRating() {
		return userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	public int getLengthMS() {
		return lengthMS;
	}

	public void setLengthMS(int lengthMS) {
		this.lengthMS = lengthMS;
	}

	public String getRecordLabel() {
		return recordLabel;
	}

	public void setRecordLabel(String recordLabel) {
		this.recordLabel = recordLabel;
	}

	public String getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	@Override
	public String toString() {
		return "Music [title=" + title + ", artist=" + artist + ", releaseDate=" + releaseDate + ", streamDate="
				+ streamDate + ", genres=" + genres + ", contentWarning=" + contentWarning + ", userRating=" + userRating
				+ ", lengthMS=" + lengthMS + ", recordLabel=" + recordLabel + ", coverImgUrl=" + coverImgUrl + "]";
	}
	
}