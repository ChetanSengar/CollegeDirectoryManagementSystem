package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(final Long id);

    Course createCourse(final Course course);

    Course updateCourse(final Long id, final Course course);

    void deleteCourse(final Long id);
}
