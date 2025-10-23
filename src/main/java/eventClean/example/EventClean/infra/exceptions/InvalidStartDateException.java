package eventClean.example.EventClean.infra.exceptions;

public class InvalidStartDateException extends RuntimeException {
    public InvalidStartDateException(String message) {

        super(message);
    }
}
