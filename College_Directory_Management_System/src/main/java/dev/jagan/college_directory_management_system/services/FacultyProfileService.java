package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.FacultyProfile;

import java.util.List;

public interface FacultyProfileService {
    public FacultyProfile createFacultyProfile(FacultyProfile facultyProfile);
    public FacultyProfile getFacultyProfileById(Long id);
    public FacultyProfile updateFacultyProfile(Long id, FacultyProfile facultyProfile);
    public void deleteFacultyProfile(Long id);
    public List<FacultyProfile> getAllFacultyProfiles();
}
