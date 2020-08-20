package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.ClassScheduleDao;
import com.example.demo.dao.ClassesDao;
import com.example.demo.dao.ProffyDao;
import com.example.demo.model.ClassSchedule;
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

	@RequestMapping("/study")
	public String study(
			Model model, 
			@RequestParam(value="subject", required=false) Integer filtersSubject,
			@RequestParam(value="weekday", required=false) Integer filtersWeekday,
			@RequestParam(value="time", required=false) String timeToMinutes)	{
		
		List<ClassSchedule> classScheduleValues = new ArrayList<>();
				
		List<Weekday> weekdays = weekday.list();
		List<Subject> subjects = subject.list();	
	
		
		if (!(filtersSubject == null || filtersWeekday == null || timeToMinutes == "")) {
			classScheduleValues = csDao.findTeacherBySubjectWeekdayTime(filtersSubject, filtersWeekday, ClassSchedule.convertHoursToMinutes(timeToMinutes));
		} else {
			classScheduleValues = csDao.findAll();
		}
		
		model.addAttribute("subjects", subjects);
		model.addAttribute("weekdays", weekdays);
		model.addAttribute("csv", classScheduleValues);
		
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
	public String saveClasses(@RequestParam("weekday_string") List<String> weekdayString, 
								@RequestParam("time_from_string") List<String> timeFromString,
								@RequestParam("time_to_string") List<String> timeFromTo,
								Proffy proffy, 
								Classes classes) {
		
		List<ClassSchedule> classSchedules = new ArrayList<>();
		
		for (int i = 0; i < weekdayString.size(); i++) {
			ClassSchedule classSchedule = new ClassSchedule();
			classSchedule.setWeekday(Integer.parseInt(weekdayString.get(i)));
			classSchedule.setTime_from(timeFromString.get(i));
			classSchedule.setTime_to(timeFromTo.get(i));	
			
			classSchedule.setClasses(classes);			
			
			classSchedules.add(classSchedule);
		}
		
		classes.setProffy(proffy);
		
		pDao.save(proffy);
		cDao.save(classes);
		for (ClassSchedule classSchedule : classSchedules) {
			csDao.save(classSchedule);
			System.out.println(classSchedule);
		}
		
		return "ok";
	}

}
