package dev.jagan.college_directory_management_system.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "users")
public class User extends BaseModel{
    private String username;
    private String password;
    private String role;
    private String name;
    private String email;
    private String phone;
}
