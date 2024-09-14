package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class StudentProfile extends BaseModel{

    @OneToOne
    private User user;

    private String photo;
    private String department;
    private String year;
}
