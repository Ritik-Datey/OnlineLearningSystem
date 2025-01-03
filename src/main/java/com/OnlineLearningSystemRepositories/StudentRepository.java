package com.OnlineLearningSystemRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineLearningSystemEntities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
