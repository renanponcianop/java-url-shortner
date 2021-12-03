package com.project.urlshortner.exceptions;

import com.project.urlshortner.exceptions.DuplicatedUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(DuplicatedUrlException.class)
    public ResponseEntity handleDuplicatedException(DuplicatedUrlException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
    @ExceptionHandler(PrefixNotFoundException.class)
    public RedirectView handlePrefixNotFoundException(DuplicatedUrlException e) {
        return new RedirectView("/redirect/", true);
    }
}
