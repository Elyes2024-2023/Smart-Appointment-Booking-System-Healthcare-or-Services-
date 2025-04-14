package com.elyes.advanced.appointment.user.service.impl;

import com.elyes.advanced.appointment.user.model.User;
import com.elyes.advanced.appointment.user.repository.UserRepository;
import com.elyes.advanced.appointment.user.service.UserService;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of the UserService interface.
 * Provides the business logic for user management operations.
 * 
 * @author Elyes
 * @version 1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Timed(value = "user.create", description = "Time taken to create a user")
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addPasswordHistory(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    @Timed(value = "user.update", description = "Time taken to update a user")
    @CacheEvict(value = {"users", "userDetails"}, key = "#id")
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setFirstName(userDetails.getFirstName());
                    existingUser.setLastName(userDetails.getLastName());
                    existingUser.setEmail(userDetails.getEmail());
                    existingUser.setPhoneNumber(userDetails.getPhoneNumber());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @Override
    @Timed(value = "user.delete", description = "Time taken to delete a user")
    @CacheEvict(value = {"users", "userDetails"}, key = "#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Timed(value = "user.findById", description = "Time taken to find user by id")
    @Cacheable(value = "users", key = "#id")
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Timed(value = "user.findByUsername", description = "Time taken to find user by username")
    @Cacheable(value = "userDetails", key = "#username")
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Timed(value = "user.findByEmail", description = "Time taken to find user by email")
    @Cacheable(value = "userDetails", key = "#email")
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Timed(value = "user.findAll", description = "Time taken to find all users")
    @Cacheable(value = "users", key = "'all'")
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Timed(value = "user.changePassword", description = "Time taken to change password")
    @CacheEvict(value = {"users", "userDetails"}, allEntries = true)
    public boolean changePassword(Long userId, String oldPassword, String newPassword) {
        return userRepository.findById(userId)
                .map(user -> {
                    if (passwordEncoder.matches(oldPassword, user.getPassword())) {
                        user.setPassword(passwordEncoder.encode(newPassword));
                        user.addPasswordHistory(newPassword);
                        userRepository.save(user);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    @Override
    @Timed(value = "user.updateLastLogin", description = "Time taken to update last login")
    @CacheEvict(value = {"users", "userDetails"}, key = "#userId")
    public void updateLastLogin(Long userId) {
        userRepository.findById(userId).ifPresent(user -> {
            user.setLastLogin(LocalDateTime.now());
            userRepository.save(user);
        });
    }
} 