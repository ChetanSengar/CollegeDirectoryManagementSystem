package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.AdministratorProfile;

import java.util.List;

public interface AdministratorProfileService {
    public AdministratorProfile createAdministratorProfile(AdministratorProfile administratorProfile);
    public AdministratorProfile getAdministratorProfileById(Long id);
    public AdministratorProfile updateAdministratorProfile(Long id, AdministratorProfile administratorProfile);
    public void deleteAdministratorProfile(Long id);
    public List<AdministratorProfile> getAllAdministratorProfiles();
}
