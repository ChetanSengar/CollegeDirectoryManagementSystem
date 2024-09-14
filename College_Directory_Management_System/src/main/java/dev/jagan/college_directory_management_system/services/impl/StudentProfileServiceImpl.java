package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.exceptions.ResourceNotFoundException;
import dev.jagan.college_directory_management_system.models.StudentProfile;
import dev.jagan.college_directory_management_system.repositories.StudentProfileRepository;
import dev.jagan.college_directory_management_system.services.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {


    private final StudentProfileRepository studentProfileRepository;

    public StudentProfileServiceImpl(final StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public StudentProfile createStudentProfile(final StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public StudentProfile updateStudentProfile(final Long id, final StudentProfile updatedStudentProfile) {
        final Optional<StudentProfile> existingProfile = studentProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            final StudentProfile profile = existingProfile.get();
            profile.setPhoto(updatedStudentProfile.getPhoto());
            profile.setUser(updatedStudentProfile.getUser());
            profile.setDepartment(updatedStudentProfile.getDepartment());
            profile.setYear(updatedStudentProfile.getYear());
            return studentProfileRepository.save(profile);
        } else {
            throw new ResourceNotFoundException("StudentProfile not found with id: " + id);
        }
    }

    @Override
    public StudentProfile getStudentProfileById(final Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found with id: " + id));
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }

    @Override
    public void deleteStudentProfile(final Long id) {
        if (studentProfileRepository.existsById(id)) {
            studentProfileRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("StudentProfile not found with id: " + id);
        }
    }
}
