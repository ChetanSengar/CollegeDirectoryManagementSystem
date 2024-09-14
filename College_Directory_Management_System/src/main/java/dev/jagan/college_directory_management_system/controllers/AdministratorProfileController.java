package dev.jagan.college_directory_management_system.controllers;

import dev.jagan.college_directory_management_system.models.AdministratorProfile;
import dev.jagan.college_directory_management_system.services.AdministratorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/administrator")
public class AdministratorProfileController {

    @Autowired
    private AdministratorProfileService administratorProfileService;

    // POST: Create a new AdministratorProfile
    @PostMapping
    public ResponseEntity<AdministratorProfile> createAdministratorProfile(@RequestBody final AdministratorProfile administratorProfile) {
        final AdministratorProfile createdProfile = administratorProfileService.createAdministratorProfile(administratorProfile);
        return ResponseEntity.ok(createdProfile);
    }

    // GET: Retrieve an AdministratorProfile by ID
    @GetMapping("/{id}")
    public ResponseEntity<AdministratorProfile> getAdministratorProfileById(@PathVariable final Long id) {
        final AdministratorProfile administratorProfile = administratorProfileService.getAdministratorProfileById(id);
        return ResponseEntity.ok(administratorProfile);
    }

    // GET: Retrieve all AdministratorProfiles
    @GetMapping
    public ResponseEntity<List<AdministratorProfile>> getAllAdministratorProfiles() {
        final List<AdministratorProfile> administratorProfiles = administratorProfileService.getAllAdministratorProfiles();
        return ResponseEntity.ok(administratorProfiles);
    }

    // PUT: Update an AdministratorProfile by ID
    @PutMapping("/{id}")
    public ResponseEntity<AdministratorProfile> updateAdministratorProfile(@PathVariable final Long id, @RequestBody final AdministratorProfile administratorProfile) {
        final AdministratorProfile updatedProfile = administratorProfileService.updateAdministratorProfile(id, administratorProfile);
        return ResponseEntity.ok(updatedProfile);
    }

    // DELETE: Delete an AdministratorProfile by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministratorProfile(@PathVariable final Long id) {
        administratorProfileService.deleteAdministratorProfile(id);
        return ResponseEntity.noContent().build();
    }
}
