package com.OnlineLearningSystemServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineLearningSystemEntities.Course;
import com.OnlineLearningSystemRepositories.CourseRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id)
                .map(course -> {
                    course.setName(updatedCourse.getName());
                    course.setDescription(updatedCourse.getDescription());
                    return courseRepository.save(course);
                }).orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}


