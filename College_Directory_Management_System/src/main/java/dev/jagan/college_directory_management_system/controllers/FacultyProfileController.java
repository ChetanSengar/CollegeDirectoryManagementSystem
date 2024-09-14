package dev.jagan.college_directory_management_system.controllers;

import dev.jagan.college_directory_management_system.models.FacultyProfile;
import dev.jagan.college_directory_management_system.services.FacultyProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty-profile")
public class FacultyProfileController {

    private FacultyProfileService facultyProfileService;

    public FacultyProfileController(FacultyProfileService facultyProfileService) {
        this.facultyProfileService = facultyProfileService;
    }

    // Create a new FacultyProfile
    @PostMapping
    public ResponseEntity<FacultyProfile> createFacultyProfile(@RequestBody FacultyProfile facultyProfile) {
        FacultyProfile createdProfile = facultyProfileService.createFacultyProfile(facultyProfile);
        return ResponseEntity.ok(createdProfile);
    }

    // Get a single FacultyProfile by id
    @GetMapping("/{id}")
    public ResponseEntity<FacultyProfile> getFacultyProfileById(@PathVariable Long id) {
        FacultyProfile facultyProfile = facultyProfileService.getFacultyProfileById(id);
        return ResponseEntity.ok(facultyProfile);
    }

    // Get all FacultyProfiles
    @GetMapping
    public ResponseEntity<List<FacultyProfile>> getAllFacultyProfiles() {
        List<FacultyProfile> facultyProfiles = facultyProfileService.getAllFacultyProfiles();
        return ResponseEntity.ok(facultyProfiles);
    }

    // Update FacultyProfile by id
    @PutMapping("/{id}")
    public ResponseEntity<FacultyProfile> updateFacultyProfile(@PathVariable Long id, @RequestBody FacultyProfile facultyProfile) {
        FacultyProfile updatedProfile = facultyProfileService.updateFacultyProfile(id, facultyProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    // Delete FacultyProfile by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacultyProfile(@PathVariable Long id) {
        facultyProfileService.deleteFacultyProfile(id);
        return ResponseEntity.noContent().build();
    }
}
