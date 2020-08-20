package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Classes;

public interface ClassesDao extends JpaRepository<Classes, Integer>{

	@Query(value =
			"SELECT classes.*, proffy.* FROM proffy " + 					
			"JOIN classes ON (classes.proffy_proffy_id = proffy.proffy_id) " + 
			"WHERE EXISTS (" + 
				"SELECT class_schedule.*" + 
				"FROM class_schedule" + 
				"WHERE class_schedule.class_id_id = classes.id " + 
				"AND class_schedule.weekday = :filters.weekday " + 
				"AND class_schedule.time_from <= :timeToMinutes " + 
				"AND class_schedule.time_to > :timeToMinutes" + 
			")" + 
			"AND classes.subject = ':filters.subject'", 			   
			  nativeQuery = true)
	List<Classes> findAllUsersWithFilter(
						@Param("filters.weekday") Integer filtersWeekday, 
						@Param("timeToMinutes") Integer timeToMinutes,
						@Param("filters.subject") Integer filtersSubject);
	
	

}
