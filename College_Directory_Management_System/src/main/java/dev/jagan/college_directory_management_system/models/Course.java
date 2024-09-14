package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Course extends BaseModel{
    private String title;
    private String description;

    @ManyToOne
    private Department department;

    @ManyToOne
    private FacultyProfile faculty;
}
