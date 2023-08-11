package com.projectmanagementsystem.backend;

import com.projectmanagementsystem.models.UserModel;
import com.projectmanagementsystem.repositories.UserRepository;
import com.projectmanagementsystem.security.services.UserDetailsImpl;
import com.projectmanagementsystem.security.services.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class UserDetailServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @Test
    void testLoadUserByUsername() {
        // Arrange
        MockitoAnnotations.openMocks(this);
        String username = "TestUser";
        String password = "testPassword";
        UserModel user = new UserModel(username,"pauline", password );
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // Act
        UserDetailsImpl userDetails = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        // Assert
        assertEquals(username, userDetails.getUsername());
        assertEquals(password, userDetails.getPassword());
        // Additional assertions based on your UserDetailsImpl implementation
    }
}
