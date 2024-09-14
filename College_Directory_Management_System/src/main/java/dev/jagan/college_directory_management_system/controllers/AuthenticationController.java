package dev.jagan.college_directory_management_system.controllers;

import dev.jagan.college_directory_management_system.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody final User user) {
        try {
            final String token = authenticationService.authenticateUser(user.getUsername(), user.getPassword());
            return ResponseEntity.ok(token);
        } catch (final Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
