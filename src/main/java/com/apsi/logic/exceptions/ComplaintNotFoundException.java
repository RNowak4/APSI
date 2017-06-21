package com.apsi.logic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Complaint not found!")
public class ComplaintNotFoundException extends  Exception{
}
