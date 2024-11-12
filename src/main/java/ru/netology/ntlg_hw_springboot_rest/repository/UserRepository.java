package ru.netology.ntlg_hw_springboot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.ntlg_hw_springboot_rest.domain.Authorities;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(String user, String password) {
        return Collections.emptyList();
    }
}