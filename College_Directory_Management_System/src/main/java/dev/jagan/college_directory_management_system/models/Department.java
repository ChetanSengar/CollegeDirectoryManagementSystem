package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department extends BaseModel{
    private String title;
    private String description;
}
