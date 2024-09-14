package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    Department getDepartmentById(final Long id);

    Department createDepartment(final Department department);

    Department updateDepartment(final Long id, final Department department);

    void deleteDepartment(final Long id);
}
