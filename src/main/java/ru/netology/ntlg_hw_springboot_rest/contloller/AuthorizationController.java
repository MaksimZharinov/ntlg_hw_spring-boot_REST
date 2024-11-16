package ru.netology.ntlg_hw_springboot_rest.contloller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.ntlg_hw_springboot_rest.domain.Authorities;
import ru.netology.ntlg_hw_springboot_rest.exception.InvalidCredentials;
import ru.netology.ntlg_hw_springboot_rest.exception.UnauthorizedUser;
import ru.netology.ntlg_hw_springboot_rest.model.User;
import ru.netology.ntlg_hw_springboot_rest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    @Autowired
    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> icEx(InvalidCredentials e) {
        return new ResponseEntity<>("Status code: " + HttpStatus.BAD_REQUEST + "\n" +
                "Message: " + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> uuEx(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>("Status code: " + HttpStatus.UNAUTHORIZED + "\n" +
                "Message: " + e.getMessage(),
                HttpStatus.UNAUTHORIZED);
    }
}
