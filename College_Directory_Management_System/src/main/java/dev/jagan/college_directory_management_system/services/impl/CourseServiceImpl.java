package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.models.Course;
import dev.jagan.college_directory_management_system.repositories.CourseRepository;
import dev.jagan.college_directory_management_system.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(final Long id) {
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course createCourse(final Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(final Long id, final Course course) {
        final Course existingCourse = getCourseById(id);
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setDepartment(course.getDepartment());
        existingCourse.setFaculty(course.getFaculty());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(final Long id) {
        courseRepository.deleteById(id);
    }
}

