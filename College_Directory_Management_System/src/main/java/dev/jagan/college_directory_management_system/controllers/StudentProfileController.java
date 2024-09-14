package dev.jagan.college_directory_management_system.controllers;

import dev.jagan.college_directory_management_system.models.StudentProfile;
import dev.jagan.college_directory_management_system.services.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-profile")
public class StudentProfileController {


    private StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    // Create a new StudentProfile
    @PostMapping
    public ResponseEntity<StudentProfile> createStudentProfile(@RequestBody StudentProfile studentProfile) {
        StudentProfile createdProfile = studentProfileService.createStudentProfile(studentProfile);
        return ResponseEntity.ok(createdProfile);
    }

    // Get a single StudentProfile by id
    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentProfileById(@PathVariable Long id) {
        StudentProfile studentProfile = studentProfileService.getStudentProfileById(id);
        return ResponseEntity.ok(studentProfile);
    }

    // Get all StudentProfiles
    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudentProfiles() {
        List<StudentProfile> studentProfiles = studentProfileService.getAllStudentProfiles();
        return ResponseEntity.ok(studentProfiles);
    }

    // Update StudentProfile by id
    @PutMapping("/{id}")
    public ResponseEntity<StudentProfile> updateStudentProfile(@PathVariable Long id, @RequestBody StudentProfile studentProfile) {
        StudentProfile updatedProfile = studentProfileService.updateStudentProfile(id, studentProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    // Delete StudentProfile by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentProfile(@PathVariable Long id) {
        studentProfileService.deleteStudentProfile(id);
        return ResponseEntity.noContent().build();
    }
}
