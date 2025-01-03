package com.OnlineLearningSystemRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OnlineLearningSystemEntities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
	
}
