package io.hsankalp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Review {

	@Id
	@GenericGenerator(strategy = "uuid2", name = "myuuid")
	@GeneratedValue(generator = "myuuid")
	private String id;
	
	private String title;
	private String email;
	private String comments;
	private String userRatings;
	
	public Review(String id, String title, String email, String comments, String userRatings) {
		this.id = id;
		this.title = title;
		this.email = email;
		this.comments = comments;
		this.userRatings = userRatings;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserRatings() {
		return userRatings;
	}

	public void setUserRatings(String userRatings) {
		this.userRatings = userRatings;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
