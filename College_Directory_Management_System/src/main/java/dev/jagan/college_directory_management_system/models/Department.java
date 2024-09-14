package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department extends BaseModel {

    @Column(nullable = false, length = 100)
    private String name;

    @Column
    private String description;
}
