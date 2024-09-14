package dev.jagan.college_directory_management_system.services.impl;

import dev.jagan.college_directory_management_system.models.User;
import dev.jagan.college_directory_management_system.repositories.UserRepository;
import dev.jagan.college_directory_management_system.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(final Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User createUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(final Long id, final User user) {
        final User existingUser = getUserById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setRole(user.getRole());
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
    }
}