package dev.jagan.college_directory_management_system.services;

import dev.jagan.college_directory_management_system.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(final Long id);

    User createUser(final User user);

    User updateUser(final Long id, final User user);

    void deleteUser(final Long id);
}
