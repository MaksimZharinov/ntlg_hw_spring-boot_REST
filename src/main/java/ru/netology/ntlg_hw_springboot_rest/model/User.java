package ru.netology.ntlg_hw_springboot_rest.model;

import lombok.Getter;
import lombok.Setter;
import ru.netology.ntlg_hw_springboot_rest.domain.Authorities;

import java.util.List;

@Getter
@Setter
public class User {

    private String name;
    private String password;
    private List<Authorities> authorities;

    public User(String name,
                String password,
                List<Authorities> authorities) {
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

}
