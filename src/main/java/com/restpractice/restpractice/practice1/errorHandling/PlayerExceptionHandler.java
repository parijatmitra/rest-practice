package com.restpractice.restpractice.practice1.errorHandling;

import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.engine.spi.EntityEntry;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class PlayerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> playerNotFoundHandler(PlayerNotFoundException playerNotFoundException, HttpServletRequest req) {
        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                req.getRequestURI(),
                playerNotFoundException.getMessage()
        );
        return new ResponseEntity<PlayerErrorResponse>(playerErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PlayerErrorResponse> genericHandler(Exception exception, HttpServletRequest req) {
        PlayerErrorResponse playerErrorResponse = new PlayerErrorResponse(
                ZonedDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                req.getRequestURI(),
                exception.getMessage()
        );
        return new ResponseEntity<>(playerErrorResponse, HttpStatus.BAD_REQUEST);
    }


}
