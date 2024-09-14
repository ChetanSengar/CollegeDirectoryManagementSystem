package dev.jagan.college_directory_management_system.repositories;

import dev.jagan.college_directory_management_system.models.AdministratorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorProfileRepository extends JpaRepository<AdministratorProfile, Long>{
    // Custom query methods if needed
}
