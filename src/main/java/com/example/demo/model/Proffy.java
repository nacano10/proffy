package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proffy {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int proffy_id;
	
	@Column
	private String name;
	
	@Column
	private String avatar;
	
	@Column
	private String whatsapp;
	
	@Column
	private String bio;
	
	public int getProffy_id() {
		return proffy_id;
	}

	public Proffy(String name, String avatar, String whatsapp, String bio) {
	super();
	this.name = name;
	this.avatar = avatar;
	this.whatsapp = whatsapp;
	this.bio = bio;
}

	public void setProffy_id(int proffy_id) {
		this.proffy_id = proffy_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "Proffy [proffy_id=" + proffy_id + ", name=" + name + ", avatar=" + avatar + ", whatsapp=" + whatsapp
				+ ", bio=" + bio + "]";
	}


	
	

	
	
}
