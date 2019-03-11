package me.seungwoo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Leo.
 * User: ssw
 * Date: 2019-03-05
 * Time: 15:10
 */
@RestController
@RequiredArgsConstructor
public class MainController {

    private final PersonRepository personRepository;

    @GetMapping("/header")
    public ResponseEntity<ExResponse> test(@RequestHeader HttpHeaders httpHeaders) {
        System.out.println("=============header=============");
        List<Person> personList = personRepository.findAll();
        throw new CustomException(httpHeaders);
        /*return new ResponseEntity<>(
                new ExResponse.Builder<>(personList)
                        .build(), httpHeaders, HttpStatus.OK);*/
    }

    @PostMapping("/test")
    public String demo(@RequestHeader HttpHeaders httpHeaders) {
        return "demo";
    }
}
