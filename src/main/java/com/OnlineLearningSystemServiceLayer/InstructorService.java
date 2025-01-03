package com.OnlineLearningSystemServiceLayer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineLearningSystemEntities.Instructor;
import com.OnlineLearningSystemRepositories.InstructorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor addInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor updateInstructor(Long id, Instructor updatedInstructor) {
        return instructorRepository.findById(id)
                .map(instructor -> {
                    instructor.setName(updatedInstructor.getName());
                    instructor.setSpecialization(updatedInstructor.getSpecialization());
                    return instructorRepository.save(instructor);
                }).orElseThrow(() -> new EntityNotFoundException("Instructor not found"));
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }
}

