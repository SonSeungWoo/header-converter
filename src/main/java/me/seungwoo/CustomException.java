package me.seungwoo;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 16:46
 */
public class CustomException extends RuntimeException {

    public CustomException() {
        super("not found");
    }
}
