package dev.jagan.college_directory_management_system.controllers;

import dev.jagan.college_directory_management_system.models.AdministratorProfile;
import dev.jagan.college_directory_management_system.services.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrator-profile")
public class AdministratorProfileController {

    private AdministratorProfileService administratorProfileService;

    public AdministratorProfileController(AdministratorProfileService administratorProfileService) {
        this.administratorProfileService = administratorProfileService;
    }

    // Create a new AdministratorProfile
    @PostMapping
    public ResponseEntity<AdministratorProfile> createAdministratorProfile(@RequestBody AdministratorProfile administratorProfile) {
        AdministratorProfile createdProfile = administratorProfileService.createAdministratorProfile(administratorProfile);
        return ResponseEntity.ok(createdProfile);
    }

    // Get a single AdministratorProfile by id
    @GetMapping("/{id}")
    public ResponseEntity<AdministratorProfile> getAdministratorProfileById(@PathVariable Long id) {
        AdministratorProfile administratorProfile = administratorProfileService.getAdministratorProfileById(id);
        return ResponseEntity.ok(administratorProfile);
    }

    // Get all AdministratorProfiles
    @GetMapping
    public ResponseEntity<List<AdministratorProfile>> getAllAdministratorProfiles() {
        List<AdministratorProfile> administratorProfiles = administratorProfileService.getAllAdministratorProfiles();
        return ResponseEntity.ok(administratorProfiles);
    }

    // Update AdministratorProfile by id
    @PutMapping("/{id}")
    public ResponseEntity<AdministratorProfile> updateAdministratorProfile(@PathVariable Long id, @RequestBody AdministratorProfile administratorProfile) {
        AdministratorProfile updatedProfile = administratorProfileService.updateAdministratorProfile(id, administratorProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    // Delete AdministratorProfile by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministratorProfile(@PathVariable Long id) {
        administratorProfileService.deleteAdministratorProfile(id);
        return ResponseEntity.noContent().build();
    }
}
