package com.apsi.logic.controllers;

import com.apsi.logic.exceptions.ClientAlreadyExistsException;
import com.apsi.logic.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/client")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping(value = "/client", method = RequestMethod.POST)
    public void registerNewClient(@RequestParam("userName") final String userName,
                                  @RequestParam("email") final String email,
                                  @RequestParam("name") final String name,
                                  @RequestParam("surname") final String surname,
                                  @RequestParam(value = "surname", required = false) final String address)
            throws ClientAlreadyExistsException {

        clientService.registerClient(userName, email, name, surname, address);
    }
}