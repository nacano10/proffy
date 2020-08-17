package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.ClassScheduleDao;
import com.example.demo.dao.ClassesDao;
import com.example.demo.dao.ProffyDao;
import com.example.demo.model.Classes;
import com.example.demo.model.Proffy;
import com.example.demo.model.Subject;
import com.example.demo.model.Weekday;

@Controller
public class IndexController {
	
	@Autowired
	ProffyDao pDao;
	
	@Autowired
	ClassesDao cDao;
	
	@Autowired
	ClassScheduleDao csDao;
	
	@Autowired
	Weekday weekday;
	
	@Autowired
	Subject subject;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/study")
	public String study() {
		return "study";
	}

	@GetMapping("/give-classes")
	public String giveClasses(Model model) {
		List<Weekday> weekdays = weekday.list();
		List<Subject> subjects = subject.list();
		model.addAttribute("weekdays", weekdays);
		model.addAttribute("subjects", subjects);
		return "give-classes";
	}
	
	@PostMapping("/save-classes")
	public String saveClasses(Proffy proffy, Classes classes) {
//		adicionar horario
		classes.setProffy(proffy);
		pDao.save(proffy);
		cDao.save(classes);
		return "ok";
	}
	
}
