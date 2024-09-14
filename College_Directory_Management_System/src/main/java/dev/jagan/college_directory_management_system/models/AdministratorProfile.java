package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AdministratorProfile extends BaseModel{
    private String photo;
    private String department;
    private String role;
    private String email;
    private String phone;
    private String address;
}
