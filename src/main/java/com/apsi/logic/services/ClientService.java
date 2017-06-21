package com.apsi.logic.services;

import com.apsi.domain.Client;
import com.apsi.domain.repositories.ClientRepository;
import com.apsi.logic.exceptions.ClientAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void registerClient(String login, String password, String email, String name, String surname, String address)
            throws ClientAlreadyExistsException {
        final Client client = new Client(login, passwordEncoder.encode(password), email, name, surname, address);
        final Optional<Client> foundUser = clientRepository.findClientByLogin(login);

        if (foundUser.isPresent()) {
            throw new ClientAlreadyExistsException("Client with such email: " + login + " already exists!");
        }

        clientRepository.save(client);
    }

    public Optional<Client> findClientByLogin(String login) {
        return clientRepository.findClientByLogin(login);
    }
}