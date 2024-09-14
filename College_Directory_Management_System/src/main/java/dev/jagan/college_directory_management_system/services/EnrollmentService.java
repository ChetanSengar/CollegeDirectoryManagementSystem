package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.Enrollment;

import java.util.List;

public interface EnrollmentService {

    List<Enrollment> getAllEnrollments();

    Enrollment getEnrollmentById(final Long id);

    Enrollment createEnrollment(final Enrollment enrollment);

    Enrollment updateEnrollment(final Long id, final Enrollment enrollment);

    void deleteEnrollment(final Long id);
}
