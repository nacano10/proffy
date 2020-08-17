package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Subject {
	
	private int id;
	private String subject;
	
	public Subject(int id, String subject) {
		this.id = id;
		this.subject = subject;
	}

	public Subject() {
	}
	
	public List<Subject> list() {
		List<Subject> subjects = new ArrayList<>();
		Subject s1 = new Subject(1, "Artes");
		Subject s2 = new Subject(2, "Biologia");
		Subject s3 = new Subject(3, "Ciências");
		Subject s4 = new Subject(4, "Educação física");
		Subject s5 = new Subject(5, "Física");
		Subject s6 = new Subject(6, "Geografia");
		Subject s7 = new Subject(7, "História");
		Subject s8 = new Subject(8, "Matemática");
		Subject s9 = new Subject(9, "Português");
		Subject s10 = new Subject(10, "Química");
		subjects.add(s1);
		subjects.add(s2);
		subjects.add(s3);
		subjects.add(s4);
		subjects.add(s5);
		subjects.add(s6);
		subjects.add(s7);
		subjects.add(s8);
		subjects.add(s9);
		subjects.add(s10);
		return subjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	

}
