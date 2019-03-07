package me.seungwoo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-07
 * Time: 14:09
 */
@Slf4j
@Controller
@RequestMapping("/error")
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @GetMapping
    public String test(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status.equals(HttpStatus.BAD_REQUEST.value())) {
            return "redirect:" + PATH + "/400";
        } else if (status.equals(HttpStatus.FORBIDDEN.value())) {
            return "redirect:" + PATH + "/403";
        } else if (status.equals(HttpStatus.NOT_FOUND.value())) {
            return "redirect:" + PATH + "/404";
        } else if (status.equals(HttpStatus.METHOD_NOT_ALLOWED.value())) {
            return "redirect:" + PATH + "/405";
        } else if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR.value())) {
            return "redirect:" + PATH + "/500";
        } else if (status.equals(HttpStatus.SERVICE_UNAVAILABLE.value())) {
            return "redirect:" + PATH + "/503";
        }
        return "error";
    }

    @GetMapping(value = "/400")
    @ResponseBody
    public ResponseEntity<ExResponse> unauthorized(HttpServletRequest request) {
        String msg = "400 잘못 된 요청 입니다.";
        return ResponseEntity.ok(
                new ExResponse
                        .Builder<>(null, msg, null)
                        .setIsSucceed(false)
                        .setIsWarning(false)
                        .build());
    }

    @GetMapping(value = "/403")
    @ResponseBody
    public ResponseEntity<ExResponse> forbidden(HttpServletRequest request) {
        String msg = "403 사용 권한 없음 액세스가 거부되었습니다.";
        return ResponseEntity.ok(
                new ExResponse
                        .Builder<>(null, msg, null)
                        .setIsSucceed(false)
                        .setIsWarning(false)
                        .build());
    }

    @GetMapping(value = "/404")
    @ResponseBody
    public ResponseEntity<ExResponse> notFoundError(HttpServletRequest request) {
        String msg = "404 찾을 수 없는 페이지입니다.";
        return ResponseEntity.ok(
                new ExResponse
                        .Builder<>(null, msg, null)
                        .setIsSucceed(false)
                        .setIsWarning(false)
                        .build());
    }

    @GetMapping(value = "/405")
    @ResponseBody
    public ResponseEntity<ExResponse> methodNotAllowed(HttpServletRequest request) {
        String msg = "405 메서드가 허용되지 않습니다. ";
        return ResponseEntity.ok(
                new ExResponse
                        .Builder<>(null, msg, null)
                        .setIsSucceed(false)
                        .setIsWarning(false)
                        .build());
    }

    @GetMapping(value = "/500")
    @ResponseBody
    public ResponseEntity<ExResponse> serverError(HttpServletRequest request) {
        String msg = "500 서버 에러";
        return ResponseEntity.ok(
                new ExResponse
                        .Builder<>(null, msg, null)
                        .setIsSucceed(false)
                        .setIsWarning(false)
                        .build());
    }

    @GetMapping(value = "/503")
    public ResponseEntity<ExResponse> serviceUnavailable(HttpServletRequest request) {
        String msg = "503 현재 서비스가 불가능 합니다.";
        return ResponseEntity.ok(
                new ExResponse
                        .Builder<>(null, msg, null)
                        .setIsSucceed(false)
                        .setIsWarning(false)
                        .build());
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
