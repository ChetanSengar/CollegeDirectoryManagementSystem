package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.StudentProfile;
import org.springframework.stereotype.Component;

import java.util.List;


public interface StudentProfileService {
    public StudentProfile createStudentProfile(StudentProfile studentProfile);
    public StudentProfile getStudentProfileById(Long id);
    public StudentProfile updateStudentProfile(Long id, StudentProfile studentProfile);
    public void deleteStudentProfile(Long id);
    public List<StudentProfile> getAllStudentProfiles();
}
