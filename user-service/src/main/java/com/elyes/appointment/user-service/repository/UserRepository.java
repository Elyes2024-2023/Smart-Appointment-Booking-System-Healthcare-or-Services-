package com.elyes.advanced.appointment.user.repository;

import com.elyes.advanced.appointment.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repository interface for User entity.
 * Provides basic CRUD operations and custom query methods.
 * 
 * @author Elyes
 * @version 1.0
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
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
     * Check if a username exists in the database.
     * 
     * @param username the username to check
     * @return true if the username exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Check if an email address exists in the database.
     * 
     * @param email the email address to check
     * @return true if the email exists, false otherwise
     */
    boolean existsByEmail(String email);
} 