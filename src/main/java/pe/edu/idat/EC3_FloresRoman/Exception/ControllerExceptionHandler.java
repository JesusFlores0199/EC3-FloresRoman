package pe.edu.idat.EC3_FloresRoman.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(
            ResourceNotFoundException.class)
    @ResponseStatus(
            value = HttpStatus.NOT_FOUND)
    public ErrorMenssage resourceNotFoundException(
            ResourceNotFoundException ex,
            WebRequest request
    ){
        return new ErrorMenssage(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                ex.getMessage(),
                request.getDescription(
                        false));
    }
}