package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClassSchedule {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Classes class_id;
	
	@Column
	private int weekday;
	
	@Column
	private int time_from;
	
	@Column
	private int time_to;
	
	public int convertHoursToMinutes(String time) {
        int hour = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        return ((hour * 60) + minutes);
    }
	
	public ClassSchedule() {
	}

	public ClassSchedule(int id, int weekday, int time_from, int time_to) {
		this.id = id;
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

	public Classes getClasses() {
		return class_id;
	}

	public void setClasses(Classes class_id) {
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

	public void setTime_from(String time_from) {
		this.time_from = convertHoursToMinutes(time_from);
	}

	public int getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = convertHoursToMinutes(time_to);
	}

	@Override
	public String toString() {
		return "ClassSchedule [id=" + id + ", classes=" + class_id + ", weekday=" + weekday + ", time_from=" + time_from
				+ ", time_to=" + time_to + "]";
	}
	
	
	
	

	

	
	
	
	
}
