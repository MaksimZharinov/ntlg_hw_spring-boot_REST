package ru.netology.ntlg_hw_springboot_rest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidCredentials extends RuntimeException {
    public InvalidCredentials(String msg) {
        super(msg);
    }
}