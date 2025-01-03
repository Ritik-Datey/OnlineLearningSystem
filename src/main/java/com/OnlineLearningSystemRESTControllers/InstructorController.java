package com.OnlineLearningSystemRESTControllers;

import com.OnlineLearningSystemEntities.Instructor;
import com.OnlineLearningSystemServiceLayer.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.addInstructor(instructor);
        return ResponseEntity.ok(savedInstructor);
    }

    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        return ResponseEntity.ok(instructors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        Optional<Instructor> instructor = instructorService.getInstructorById(id);
        return instructor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor updatedInstructor) {
        Instructor instructor = instructorService.updateInstructor(id, updatedInstructor);
        return ResponseEntity.ok(instructor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable Long id) {
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}

