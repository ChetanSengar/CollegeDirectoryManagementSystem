package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FacultyProfile extends BaseModel{


    private String photo;
    private String department;

}
