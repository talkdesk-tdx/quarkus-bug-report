package org.example.errorhandling;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

import javax.enterprise.context.ApplicationScoped;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
@ApplicationScoped
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(final ConstraintViolationException exception) {
        return Response.status(BAD_REQUEST).build();
    }
}
