package com.example.labxpert.Exception.advice;

import com.example.labxpert.Exception.MessageErrorException.MessageError;
import com.example.labxpert.Exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return errorMap;
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageError> hanldeBusinessException(NotFoundException exception)
    {
        MessageError messageError = new MessageError(exception.getMessage());
        return new ResponseEntity<>(messageError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<MessageError> hanldeValidationException(ValidationException exception)
    {
        String errorMessage = "Validation service error: " + exception.getMessage();
        MessageError messageError = new MessageError(errorMessage);
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
