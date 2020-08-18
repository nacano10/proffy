package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Classes {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String subject;
	
	@Column
	private String cost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Proffy proffy;	
	
	
		
	public Classes() {
	}

	public Classes(String subject, String cost, Proffy proffy) {
		this.subject = subject;
		this.cost = cost;
		this.proffy = proffy;
	}

	public int getClass_id() {
		return id;
	}

	public void setClass_id(int class_id) {
		this.id = class_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}	

	public Proffy getProffy() {
		return proffy;
	}

	public void setProffy(Proffy proffy) {
		this.proffy = proffy;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", subject=" + subject + ", cost=" + cost + ", proffy=" + proffy + "]";
	}

	

	

	
	
	

}
