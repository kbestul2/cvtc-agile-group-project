package edu.cvtc.agile.model;

import java.io.Serializable;

public class Music extends Content implements Serializable {

	private static final long serialVersionUID = 3605785336363110316L;

	private String name;
	private String releaseDate;
	private String streamDate;
	private String artist;
	private String album;
	private int lengthInMinutes;
	private int lengthInSeconds;
	private float rating;
	private String coverImgUrl;

	public Music(String name, String releaseDate, String streamDate, String artist, String album, int lengthInMinutes,
			int lengthInSeconds, float ratingNumber, String coverImgUrl) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.streamDate = streamDate;
		this.artist = artist;
		this.album = album;
		this.lengthInMinutes = lengthInMinutes;
		this.lengthInSeconds = lengthInSeconds;
		this.rating = ratingNumber;
		this.coverImgUrl = coverImgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getStreamDate() {
		return streamDate;
	}

	public void setStreamDate(String streamDate) {
		this.streamDate = streamDate;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getLengthInMinutes() {
		return lengthInMinutes;
	}

	public void setLengthInMinutes(int lengthInMinutes) {
		this.lengthInMinutes = lengthInMinutes;
	}

	public int getLengthInSeconds() {
		return lengthInSeconds;
	}

	public void setLengthInSeconds(int lengthInSeconds) {
		this.lengthInSeconds = lengthInSeconds;
	}

	public float getRatingNumber() {
		return rating;
	}

	public void setRatingNumber(float ratingNumber) {
		this.rating = ratingNumber;
	}

	public String getCoverImgUrl() {
		return coverImgUrl;
	}

	public void setCoverImgUrl(String coverImgUrl) {
		this.coverImgUrl = coverImgUrl;
	}

	@Override
	public String toString() {
		return "Music [name=" + name + ", releaseDate=" + releaseDate + ", streamDate=" + streamDate + ", artist="
				+ artist + ", album=" + album + ", lengthInMinutes=" + lengthInMinutes + ", lengthInSeconds="
				+ lengthInSeconds + ", ratingNumber=" + rating + ", coverImgUrl=" + coverImgUrl + "]";
	}

}