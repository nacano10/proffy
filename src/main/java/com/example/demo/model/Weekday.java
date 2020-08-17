package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Weekday {
	
	private int id;
	private String day;
	
	
	public Weekday(int id, String day) {
		this.id = id;
		this.day = day;
	}
	
	
	public Weekday() {		
	}

	public List<Weekday> list() {
		List<Weekday> weekdays = new ArrayList<>();
		Weekday sunday = new Weekday(0, "Domingo");
		Weekday monday = new Weekday(1, "Segunda-feira");
		Weekday tuesday = new Weekday(2, "Terça-feira");
		Weekday wednesday = new Weekday(3, "Quarta-feira");
		Weekday thursday = new Weekday(4, "Quinta-feira");
		Weekday friday = new Weekday(5, "Sexta-feita");
		Weekday saturday = new Weekday(6, "Sábado");
		weekdays.add(sunday);
		weekdays.add(monday);
		weekdays.add(tuesday);
		weekdays.add(wednesday);
		weekdays.add(thursday);
		weekdays.add(friday);
		weekdays.add(saturday);	
		return weekdays;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	
	
}
