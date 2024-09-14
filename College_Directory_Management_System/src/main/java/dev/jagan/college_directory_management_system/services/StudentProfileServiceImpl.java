package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.exceptions.ResourceNotFoundException;
import dev.jagan.college_directory_management_system.models.StudentProfile;
import dev.jagan.college_directory_management_system.repositories.StudentProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {


    private StudentProfileRepository studentProfileRepository;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public StudentProfile createStudentProfile(StudentProfile studentProfile) {
        return studentProfileRepository.save(studentProfile);
    }

    @Override
    public StudentProfile updateStudentProfile(Long id, StudentProfile updatedStudentProfile) {
        Optional<StudentProfile> existingProfile = studentProfileRepository.findById(id);
        if (existingProfile.isPresent()) {
            StudentProfile profile = existingProfile.get();
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
    public StudentProfile getStudentProfileById(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentProfile not found with id: " + id));
    }

    @Override
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }

    @Override
    public void deleteStudentProfile(Long id) {
        if (studentProfileRepository.existsById(id)) {
            studentProfileRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("StudentProfile not found with id: " + id);
        }
    }
}
