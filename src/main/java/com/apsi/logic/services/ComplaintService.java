package com.apsi.logic.services;

import com.apsi.domain.Client;
import com.apsi.domain.Complaint;
import com.apsi.domain.ComplaintStatus;
import com.apsi.domain.repositories.ComplaintRepository;
import com.apsi.logic.exceptions.ClientNotFoundException;
import com.apsi.logic.exceptions.ComplaintNotFoundException;
import com.apsi.logic.exceptions.NotLoggedInException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Date;

@Service
public class ComplaintService {
    private ComplaintRepository complaintRepository;
    private ClientService clientService;

    @Autowired
    public ComplaintService(ComplaintRepository complaintRepository, ClientService clientService) {
        this.complaintRepository = complaintRepository;
        this.clientService = clientService;
    }

    public void addComplaint(String login, String text, Principal principal)
            throws NotLoggedInException, ClientNotFoundException {
        if (principal == null) {
            throw new NotLoggedInException();
        }

        Client client = clientService.findClientByLogin(login)
                .map(foundClient -> foundClient)
                .orElseThrow(ClientNotFoundException::new);

        Complaint complaint = new Complaint();
        complaint.setClient(client);
        complaint.setComplaintDate(new Date());
        complaint.setText(text);
        complaint.setComplaintStatus(ComplaintStatus.NEW);

        complaintRepository.save(complaint);
    }

    public void changeComplaintStatus(Long complaintId, String status, Principal principal)
            throws ComplaintNotFoundException, NotLoggedInException {
        if (principal == null) {
            throw new NotLoggedInException();
        }

        Complaint complaint = complaintRepository.findById(complaintId)
                .map(foundComplaint -> foundComplaint)
                .orElseThrow(ComplaintNotFoundException::new);

        ComplaintStatus complaintStatus = ComplaintStatus.valueOf(status);
        complaint.setComplaintStatus(complaintStatus);

        complaintRepository.save(complaint);
    }
}