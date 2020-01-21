package org.example.errorhandling;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.ws.rs.Priorities;


@ApplicationScoped
@Priority(Priorities.AUTHENTICATION)
@Alternative
public class ConstraintViolationErrorCodeImpl implements ConstraintViolationErrorCode {

    @Override
    public ErrorCode getInvalidFieldErrorCode() {
        return new ErrorCode() {
            @Override
            public String getCode() {
                return "Invalid field";
            }
        };
    }
}
