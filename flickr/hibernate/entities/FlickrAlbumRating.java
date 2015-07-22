package com.flickr.hibernate.entities;

// Generated Jul 18, 2015 5:27:08 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * FlickrAlbumRating generated by hbm2java
 */
@Entity
@Table(name = "flickr_album_rating", schema = "public")
public class FlickrAlbumRating implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7653018002242705566L;
	
	private long albumRatingId;
	private FlickrAlbum flickrAlbum;
	private int ratingNumber;
	private long userId;
	private Date ratingCreatedDate;

	public FlickrAlbumRating() {
	}

	public FlickrAlbumRating(long albumRatingId, FlickrAlbum flickrAlbum,
			int ratingNumber, long userId, Date ratingCreatedDate) {
		this.albumRatingId = albumRatingId;
		this.flickrAlbum = flickrAlbum;
		this.ratingNumber = ratingNumber;
		this.userId = userId;
		this.ratingCreatedDate = ratingCreatedDate;
	}

	@Id
	@Column(name = "album_rating_id", unique = true, nullable = false)
	public long getAlbumRatingId() {
		return this.albumRatingId;
	}

	public void setAlbumRatingId(long albumRatingId) {
		this.albumRatingId = albumRatingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	public FlickrAlbum getFlickrAlbum() {
		return this.flickrAlbum;
	}

	public void setFlickrAlbum(FlickrAlbum flickrAlbum) {
		this.flickrAlbum = flickrAlbum;
	}

	@Column(name = "rating_number", nullable = false)
	public int getRatingNumber() {
		return this.ratingNumber;
	}

	public void setRatingNumber(int ratingNumber) {
		this.ratingNumber = ratingNumber;
	}

	@Column(name = "user_id", nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rating_created_date", nullable = false, length = 29)
	public Date getRatingCreatedDate() {
		return this.ratingCreatedDate;
	}

	public void setRatingCreatedDate(Date ratingCreatedDate) {
		this.ratingCreatedDate = ratingCreatedDate;
	}

}