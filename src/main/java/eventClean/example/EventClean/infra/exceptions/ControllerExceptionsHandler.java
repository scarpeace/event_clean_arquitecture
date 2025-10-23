package eventClean.example.EventClean.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionsHandler {

    @ExceptionHandler(DuplicateEventException.class)
    public ResponseEntity<Map<String,String>> handleDuplicateEventException(DuplicateEventException exception){
        Map<String,String> response = new HashMap<>();

        response.put("Message: ", "Please insert a valid hashId for your event and try again");
        response.put("Error: ",exception.getMessage());

        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidStartDateException.class)
    public ResponseEntity<Map<String,String>> handleInvalidStartDateException(InvalidStartDateException exception){
        Map<String,String> response = new HashMap<>();

        response.put("Message:", "Please insert a valid Starting Date for your event and try again");
        response.put("Error:", exception.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
