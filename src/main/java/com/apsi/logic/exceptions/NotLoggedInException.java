package com.apsi.logic.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "User not logged in or not authorized!")
public class NotLoggedInException extends Throwable {
}
