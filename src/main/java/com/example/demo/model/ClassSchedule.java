package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClassSchedule {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Classes class_id;
	
	@Column
	private int weekday;
	
	@Column
	private int time_from;
	
	@Column
	private int time_to;
	
	public ClassSchedule(Classes class_id, int weekday, int time_from, int time_to) {
		this.class_id = class_id;
		this.weekday = weekday;
		this.time_from = time_from;
		this.time_to = time_to;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Classes getClass_id() {
		return class_id;
	}

	public void setClass_id(Classes class_id) {
		this.class_id = class_id;
	}

	public int getWeekday() {
		return weekday;
	}

	public void setWeekday(int weekday) {
		this.weekday = weekday;
	}

	public int getTime_from() {
		return time_from;
	}

	public void setTime_from(int time_from) {
		this.time_from = time_from;
	}

	public int getTime_to() {
		return time_to;
	}

	public void setTime_to(int time_to) {
		this.time_to = time_to;
	}

	@Override
	public String toString() {
		return "ClassSchedule [id=" + id + ", class_id=" + class_id + ", weekday=" + weekday + ", time_from="
				+ time_from + ", time_to=" + time_to + "]";
	}
	
	
	
	
}
