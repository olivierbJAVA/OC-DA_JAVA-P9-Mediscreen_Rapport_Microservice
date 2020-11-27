package com.mediscreen.rapport.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class materializing the ResourceNotFoundException.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ResourceNotFoundException.
     *
     * @param message the error message
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
