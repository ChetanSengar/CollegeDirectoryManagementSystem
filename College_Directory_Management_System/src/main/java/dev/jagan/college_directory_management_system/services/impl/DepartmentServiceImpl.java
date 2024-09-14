package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.models.Department;
import dev.jagan.college_directory_management_system.repositories.DepartmentRepository;
import dev.jagan.college_directory_management_system.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(final Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Department createDepartment(final Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(final Long id, final Department department) {
        final Department existingDepartment = getDepartmentById(id);
        existingDepartment.setName(department.getName());
        existingDepartment.setDescription(department.getDescription());
        return departmentRepository.save(existingDepartment);
    }
    
    @Override
    public void deleteDepartment(final Long id) {
        departmentRepository.deleteById(id);
    }
}
