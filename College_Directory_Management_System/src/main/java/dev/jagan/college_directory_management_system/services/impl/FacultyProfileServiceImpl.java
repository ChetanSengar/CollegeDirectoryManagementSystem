package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.exceptions.ResourceNotFoundException;
import dev.jagan.college_directory_management_system.models.FacultyProfile;
import dev.jagan.college_directory_management_system.repositories.FacultyProfileRepository;
import dev.jagan.college_directory_management_system.services.FacultyProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyProfileServiceImpl implements FacultyProfileService {

    private final FacultyProfileRepository facultyProfileRepository;

    public FacultyProfileServiceImpl(final FacultyProfileRepository facultyProfileRepository) {
        this.facultyProfileRepository = facultyProfileRepository;
    }

    @Override
    public FacultyProfile createFacultyProfile(final FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    @Override
    public FacultyProfile updateFacultyProfile(final Long id, final FacultyProfile updatedFacultyProfile) {
        final Optional<FacultyProfile> existingProfile = facultyProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            final FacultyProfile profile = existingProfile.get();
            profile.setPhoto(updatedFacultyProfile.getPhoto());
//            profile.setOfficeHours(updatedFacultyProfile.getOfficeHours());
//            profile.setUser(updatedFacultyProfile.getUser());
            profile.setDepartment(updatedFacultyProfile.getDepartment());
            return facultyProfileRepository.save(profile);
        } else {
            throw new ResourceNotFoundException("FacultyProfile not found with id: " + id);
        }
    }

    @Override
    public FacultyProfile getFacultyProfileById(final Long id) {
        return facultyProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacultyProfile not found with id: " + id));
    }

    @Override
    public List<FacultyProfile> getAllFacultyProfiles() {
        return facultyProfileRepository.findAll();
    }

    @Override
    public void deleteFacultyProfile(final Long id) {
        if (facultyProfileRepository.existsById(id)) {
            facultyProfileRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("FacultyProfile not found with id: " + id);
        }
    }

}
