package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.ClassSchedule;

public interface ClassScheduleDao extends JpaRepository<ClassSchedule, Integer>{
	
//	@Query("SELECT cs FROM ClassSchedule cs "
//			+ "JOIN Classes c ON (cs.class_id = c.id)"
//			+ "WHERE c.subject = 6"
//			+ "AND cs.weekday = 2"
//			+ "AND cs.time_from <= 720"
//			+ "AND cs.time_to > 720")
//	List<ClassSchedule> findTeacherBySubjectWeekdayTime();
	
//	@Query( value = "SELECT class_schedule.* FROM class_schedule cs "
//			+ "JOIN classes c ON (cs.class_id_id = c.id)"
//			+ "WHERE c.subject = ?1 "
//			+ "AND cs.weekday = ?2 "
//			+ "AND cs.time_from <= ?3 "
//			+ "AND cs.time_to > ?4", nativeQuery = true)
//	List<ClassSchedule> findTeacherBySubjectWeekdayTime(Integer subject, Integer weekday, Integer time, Integer time2);
	
	@Query( value = "SELECT class_schedule.* FROM class_schedule "
			+ "JOIN classes ON (class_schedule.class_id_id = classes.id) "
			+ "WHERE classes.subject = ?1 "
			+ "AND weekday = ?2 "
			+ "AND class_schedule.time_from <= ?3 "
			+ "AND class_schedule.time_to > ?3", nativeQuery = true)
	List<ClassSchedule> findTeacherBySubjectWeekdayTime(Integer subject, Integer weekday, Integer time);

}
