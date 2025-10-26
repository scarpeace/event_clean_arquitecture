package eventClean.example.EventClean.infra.exceptions;

public class NotFoundEventException extends RuntimeException {
    public NotFoundEventException(String message) {
        super(message);
    }
}
