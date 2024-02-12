package cgg.springboot.restapi.restapi.exceptions;

public class AgeNotValid extends RuntimeException {
    public AgeNotValid() {
        super();

    }

    public AgeNotValid(String message) {
        super(message);

    }

}
