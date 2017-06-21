package com.apsi.logic.services;

import com.apsi.domain.User;
import com.apsi.domain.repositories.UserRepository;
import com.apsi.logic.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(final String login, final String password)
            throws UserAlreadyExistsException {
        final User user = new User(login, passwordEncoder.encode(password));
        final Optional<User> foundUser = userRepository.findUserByLogin(login);

        if (foundUser.isPresent()) {
            throw new UserAlreadyExistsException("User with such email: " + login + " already exists!");
        }

        userRepository.save(user);
    }

    Optional<User> getUserByLogin(final String login) {
        return userRepository.findUserByLogin(login);
    }
}
