package dev.jagan.college_directory_management_system.repositories;

import dev.jagan.college_directory_management_system.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
