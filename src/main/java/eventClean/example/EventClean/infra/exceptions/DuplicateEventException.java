package eventClean.example.EventClean.infra.exceptions;

public class DuplicateEventException extends RuntimeException{

    public DuplicateEventException(String message){
        super(message);
    }
}
