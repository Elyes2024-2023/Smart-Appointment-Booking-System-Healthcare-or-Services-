package com.elyes.advanced.appointment.user.service;

import com.elyes.advanced.appointment.user.model.User;
import java.util.List;
import java.util.Optional;

/**
 * Service interface for User management operations.
 * Defines the business logic for user-related operations.
 * 
 * @author Elyes
 * @version 1.0
 */
public interface UserService {
    
    /**
     * Create a new user in the system.
     * 
     * @param user the user to create
     * @return the created user
     */
    User createUser(User user);

    /**
     * Update an existing user's information.
     * 
     * @param id the user's ID
     * @param user the updated user information
     * @return the updated user
     */
    User updateUser(Long id, User user);

    /**
     * Delete a user from the system.
     * 
     * @param id the ID of the user to delete
     */
    void deleteUser(Long id);

    /**
     * Find a user by their ID.
     * 
     * @param id the user's ID
     * @return Optional containing the user if found
     */
    Optional<User> findById(Long id);

    /**
     * Find a user by their username.
     * 
     * @param username the username to search for
     * @return Optional containing the user if found
     */
    Optional<User> findByUsername(String username);

    /**
     * Find a user by their email address.
     * 
     * @param email the email address to search for
     * @return Optional containing the user if found
     */
    Optional<User> findByEmail(String email);

    /**
     * Get all users in the system.
     * 
     * @return list of all users
     */
    List<User> findAllUsers();

    /**
     * Change a user's password.
     * 
     * @param userId the user's ID
     * @param oldPassword the current password
     * @param newPassword the new password
     * @return true if password was changed successfully
     */
    boolean changePassword(Long userId, String oldPassword, String newPassword);

    /**
     * Update user's last login timestamp.
     * 
     * @param userId the user's ID
     */
    void updateLastLogin(Long userId);
} 