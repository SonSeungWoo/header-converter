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
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ExResponse> handleException(Exception e, HttpHeaders httpHeaders) {
        return new ResponseEntity<>(new ExResponse.Builder<>(e)
                .build(), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CustomException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<ExResponse> notFoundException(CustomException e, HttpHeaders httpHeaders) {
        return new ResponseEntity<>(new ExResponse.Builder<>(e)
                .build(), httpHeaders, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = IllegalStateException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<ExResponse> illegalStateException(IllegalStateException e, HttpHeaders httpHeaders) {
        return new ResponseEntity<>(new ExResponse.Builder<>(e)
                .build(), httpHeaders, HttpStatus.NOT_FOUND);
    }
}
