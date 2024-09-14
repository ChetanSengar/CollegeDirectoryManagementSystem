package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.exceptions.ResourceNotFoundException;
import dev.jagan.college_directory_management_system.models.FacultyProfile;
import dev.jagan.college_directory_management_system.repositories.FacultyProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyProfileServiceImpl implements FacultyProfileService{

    private FacultyProfileRepository facultyProfileRepository;

    public FacultyProfileServiceImpl(FacultyProfileRepository facultyProfileRepository) {
        this.facultyProfileRepository = facultyProfileRepository;
    }

    @Override
    public FacultyProfile createFacultyProfile(FacultyProfile facultyProfile) {
        return facultyProfileRepository.save(facultyProfile);
    }

    @Override
    public FacultyProfile updateFacultyProfile(Long id, FacultyProfile updatedFacultyProfile) {
        Optional<FacultyProfile> existingProfile = facultyProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            FacultyProfile profile = existingProfile.get();
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
    public FacultyProfile getFacultyProfileById(Long id) {
        return facultyProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FacultyProfile not found with id: " + id));
    }

    @Override
    public List<FacultyProfile> getAllFacultyProfiles() {
        return facultyProfileRepository.findAll();
    }

    @Override
    public void deleteFacultyProfile(Long id) {
        if (facultyProfileRepository.existsById(id)) {
            facultyProfileRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("FacultyProfile not found with id: " + id);
        }
    }

}
