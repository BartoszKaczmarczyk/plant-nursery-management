package pl.bartoszkaczmarczyk.plantnurserymanagement;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.bartoszkaczmarczyk.plantnurserymanagement.exception.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerApplication {

    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
