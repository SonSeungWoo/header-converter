package me.seungwoo;

import lombok.Getter;
import org.springframework.http.HttpHeaders;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 16:46
 */
@Getter
public class CustomException extends RuntimeException {

    private HttpHeaders httpHeaders;

    public CustomException() {
        super("not found");
    }

    public CustomException(HttpHeaders httpHeaders) {
        super("not found");
        this.httpHeaders = httpHeaders;
    }
}
