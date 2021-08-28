package com.tuanmd.socialnetwork.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	private String email;
	private String password;
	private String avatar;
	private String coverImage;
	private String qoutSentence;
	private int totalFollowers;
	private int totalFriends;
	private String company;
	private String city;
	private String university;
	private Date createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvatar() {
		return avatar + "?img=" + id;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getQoutSentence() {
		return qoutSentence;
	}

	public void setQoutSentence(String qoutSentence) {
		this.qoutSentence = qoutSentence;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getTotalFollowers() {
		return totalFollowers;
	}

	public void setTotalFollowers(int totalFollowers) {
		this.totalFollowers = totalFollowers;
	}

	public int getTotalFriends() {
		return totalFriends;
	}

	public void setTotalFriends(int totalFriends) {
		this.totalFriends = totalFriends;
	}

	public User(int id, String name, String email, String password, String avatar, String coverImage,
			String qoutSentence, int totalFollowers, int totalFriends, String company, String city, String university,
			Date createdAt) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.avatar = avatar;
		this.coverImage = coverImage;
		this.qoutSentence = qoutSentence;
		this.totalFollowers = totalFollowers;
		this.totalFriends = totalFriends;
		this.company = company;
		this.city = city;
		this.university = university;
		this.createdAt = createdAt;
	}

	public User(int id) {
		this.id = id;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", avatar="
				+ avatar + ", coverImage=" + coverImage + ", qoutSentence=" + qoutSentence + ", totalFollowers="
				+ totalFollowers + ", totalFriends=" + totalFriends + ", company=" + company + ", city=" + city
				+ ", university=" + university + ", createdAt=" + createdAt + "]";
	}

}
