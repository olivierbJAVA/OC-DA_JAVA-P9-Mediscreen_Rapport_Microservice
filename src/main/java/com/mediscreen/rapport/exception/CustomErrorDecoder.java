package com.mediscreen.rapport.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

/**
 * Class managing Feign custom errors.
 */
public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new ErrorDecoder.Default();

    private final String ResourceNotFoundExceptionMessage = "Error : Resource Not Found";

    /**
     * Manage Feign custom exceptions.
     *
     * @param invoker the invoker for the exception
     * @param response the error response
     * @return The default error decoder
     */
    @Override
    public Exception decode(String invoker, Response response) {

        if(response.status()==404) {
            return new ResourceNotFoundException(ResourceNotFoundExceptionMessage);
        }

        return defaultErrorDecoder.decode(invoker, response);
    }
}
