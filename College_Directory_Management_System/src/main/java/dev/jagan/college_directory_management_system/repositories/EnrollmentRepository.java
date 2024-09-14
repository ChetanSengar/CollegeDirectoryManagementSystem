package dev.jagan.college_directory_management_system.repositories;

import dev.jagan.college_directory_management_system.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}