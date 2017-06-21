package com.apsi.logic.controllers;

import com.apsi.logic.exceptions.ClientAlreadyExistsException;
import com.apsi.logic.exceptions.ClientNotFoundException;
import com.apsi.logic.exceptions.ComplaintNotFoundException;
import com.apsi.logic.exceptions.NotLoggedInException;
import com.apsi.logic.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController(value = "/complaint")
public class ComplaintController {
    private ComplaintService complaintService;

    @Autowired
    public ComplaintController(ComplaintService complaintService) {
        this.complaintService = complaintService;
    }


    @RequestMapping(value = "/complaint", method = RequestMethod.POST)
    public void createNewComplaint(@RequestParam("userName") final String userName,
                                   @RequestParam("text") final String text,
                                   Principal principal)
            throws ClientAlreadyExistsException, NotLoggedInException, ClientNotFoundException {

        complaintService.addComplaint(userName, text, principal);
    }

    @RequestMapping(value = "/complaint", method = RequestMethod.PUT)
    public void changeComplaintStatus(@RequestParam("complaintId") final Long complaintId,
                                      @RequestParam("status") final String status,
                                      Principal principal) throws ComplaintNotFoundException, NotLoggedInException {

        complaintService.changeComplaintStatus(complaintId, status, principal);
    }
}
