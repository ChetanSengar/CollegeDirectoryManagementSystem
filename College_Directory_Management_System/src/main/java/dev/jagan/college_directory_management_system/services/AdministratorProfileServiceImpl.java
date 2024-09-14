package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.exceptions.ResourceNotFoundException;
import dev.jagan.college_directory_management_system.models.AdministratorProfile;
import dev.jagan.college_directory_management_system.repositories.AdministratorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorProfileServiceImpl implements AdministratorProfileService{

    private AdministratorProfileRepository administratorProfileRepository;

    public AdministratorProfileServiceImpl(AdministratorProfileRepository administratorProfileRepository) {
        this.administratorProfileRepository = administratorProfileRepository;
    }

    @Override
    public AdministratorProfile createAdministratorProfile(AdministratorProfile administratorProfile) {
        return administratorProfileRepository.save(administratorProfile);
    }

    @Override
    public AdministratorProfile updateAdministratorProfile(Long id, AdministratorProfile updatedAdministratorProfile) {
        Optional<AdministratorProfile> existingProfile = administratorProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            AdministratorProfile profile = existingProfile.get();
            profile.setPhoto(updatedAdministratorProfile.getPhoto());
//            profile.setUser(updatedAdministratorProfile.getUser());
            profile.setDepartment(updatedAdministratorProfile.getDepartment());
            return administratorProfileRepository.save(profile);
        } else {
            throw new ResourceNotFoundException("AdministratorProfile not found with id: " + id);
        }
    }

    @Override
    public AdministratorProfile getAdministratorProfileById(Long id) {
        return administratorProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("AdministratorProfile not found with id: " + id));
    }

    @Override
    public List<AdministratorProfile> getAllAdministratorProfiles() {
        return administratorProfileRepository.findAll();
    }

    @Override
    public void deleteAdministratorProfile(Long id) {
        if (administratorProfileRepository.existsById(id)) {
            administratorProfileRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("AdministratorProfile not found with id: " + id);
        }
    }
}
