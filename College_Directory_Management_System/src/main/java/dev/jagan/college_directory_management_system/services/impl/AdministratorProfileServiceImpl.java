package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.exceptions.ResourceNotFoundException;
import dev.jagan.college_directory_management_system.models.AdministratorProfile;
import dev.jagan.college_directory_management_system.repositories.AdministratorProfileRepository;
import dev.jagan.college_directory_management_system.services.AdministratorProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorProfileServiceImpl implements AdministratorProfileService {

    private final AdministratorProfileRepository administratorProfileRepository;

    public AdministratorProfileServiceImpl(final AdministratorProfileRepository administratorProfileRepository) {
        this.administratorProfileRepository = administratorProfileRepository;
    }

    @Override
    public AdministratorProfile createAdministratorProfile(final AdministratorProfile administratorProfile) {
        return administratorProfileRepository.save(administratorProfile);
    }

    @Override
    public AdministratorProfile updateAdministratorProfile(final Long id, final AdministratorProfile updatedAdministratorProfile) {
        final Optional<AdministratorProfile> existingProfile = administratorProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            final AdministratorProfile profile = existingProfile.get();
            profile.setPhoto(updatedAdministratorProfile.getPhoto());
//            profile.setUser(updatedAdministratorProfile.getUser());
            profile.setDepartment(updatedAdministratorProfile.getDepartment());
            return administratorProfileRepository.save(profile);
        } else {
            throw new ResourceNotFoundException("AdministratorProfile not found with id: " + id);
        }
    }

    @Override
    public AdministratorProfile getAdministratorProfileById(final Long id) {
        return administratorProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AdministratorProfile not found with id: " + id));
    }

    @Override
    public List<AdministratorProfile> getAllAdministratorProfiles() {
        return administratorProfileRepository.findAll();
    }

    @Override
    public void deleteAdministratorProfile(final Long id) {
        if (administratorProfileRepository.existsById(id)) {
            administratorProfileRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("AdministratorProfile not found with id: " + id);
        }
    }
}
