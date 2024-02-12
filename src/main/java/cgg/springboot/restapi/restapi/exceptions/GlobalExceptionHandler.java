package cgg.springboot.restapi.restapi.exceptions;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handler for age not valid
    @ExceptionHandler(AgeNotValid.class)
    public ResponseEntity<ProblemDetail> AgeNotValidHandler(AgeNotValid e) {

        ProblemDetail pd = ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        pd.setTitle("age not valid error");
        pd.setDetail("age is not valid to cast vote");
        pd.setType(URI.create("http://localhost:8080/errors"));
        pd.setProperty("host", "local host");
        pd.setProperty("port", "8080");

        return ResponseEntity.of(pd).build();

    }

}
