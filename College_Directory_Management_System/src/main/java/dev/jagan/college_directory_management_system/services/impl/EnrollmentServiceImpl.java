package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.models.Enrollment;
import dev.jagan.college_directory_management_system.repositories.EnrollmentRepository;
import dev.jagan.college_directory_management_system.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(final Long id) {
        return enrollmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Enrollment not found"));
    }

    @Override
    public Enrollment createEnrollment(final Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public Enrollment updateEnrollment(final Long id, final Enrollment enrollment) {
        final Enrollment existingEnrollment = getEnrollmentById(id);
        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setCourse(enrollment.getCourse());
        return enrollmentRepository.save(existingEnrollment);
    }

    @Override
    public void deleteEnrollment(final Long id) {
        enrollmentRepository.deleteById(id);
    }
}
