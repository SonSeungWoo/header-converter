package me.seungwoo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 16:41
 */
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExResponse> handleException(Exception e) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(new ExResponse.Builder<>(e.getMessage())
                .build(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ExResponse> customException(CustomException e) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("isSuccess", "false");
        return new ResponseEntity<>(new ExResponse.Builder<>(e.getMessage())
                .build(), headers, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ExResponse> illegalStateException(IllegalStateException e) {
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<>(new ExResponse.Builder<>(e.getMessage())
                .build(), headers, HttpStatus.NOT_FOUND);
    }
}
