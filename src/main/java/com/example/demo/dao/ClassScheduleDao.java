package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ClassSchedule;

public interface ClassScheduleDao extends JpaRepository<ClassSchedule, Integer>{
	
	@Query( value = "SELECT class_schedule.* FROM class_schedule "
			+ "JOIN classes ON (class_schedule.class_id_id = classes.id) "
			+ "WHERE classes.subject = ?1 "
			+ "AND weekday = ?2 "
			+ "AND class_schedule.time_from <= ?3 "
			+ "AND class_schedule.time_to > ?3", nativeQuery = true)
	List<ClassSchedule> findTeacherBySubjectWeekdayTime(Integer subject, Integer weekday, Integer time);
	
	@Query(value = "SELECT class_schedule.* FROM class_schedule GROUP BY class_schedule.class_id_id", nativeQuery = true)
	List<ClassSchedule> findTeacherDistinct();

}
