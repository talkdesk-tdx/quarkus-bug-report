package org.example.errorhandling;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import io.quarkus.test.junit.QuarkusTest;
import java.util.Set;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.ws.rs.core.Response;
import lombok.Data;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ConstraintViolationExceptionMapperIT {

    @Inject
    Validator validator;

    @Inject
    ConstraintViolationExceptionMapper mapper;

    @Test
    void testResponse() {

        final Set<ConstraintViolation<Bar>> violations = validator.validate(new Bar());
        final ConstraintViolationException constraintViolationException = new ConstraintViolationException(violations);

        final Response response = mapper.toResponse(constraintViolationException);

        assertThat(response.getStatus(), is(BAD_REQUEST.getStatusCode()));
    }

    @Data
    private static class Bar {

        @NotBlank
        private String someString;

        @NotNull
        @Positive
        private Integer somePositiveNumber;
    }
}
