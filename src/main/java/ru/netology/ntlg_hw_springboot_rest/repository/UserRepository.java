package ru.netology.ntlg_hw_springboot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.ntlg_hw_springboot_rest.domain.Authorities;
import ru.netology.ntlg_hw_springboot_rest.exception.InvalidCredentials;
import ru.netology.ntlg_hw_springboot_rest.exception.UnauthorizedUser;
import ru.netology.ntlg_hw_springboot_rest.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private final ConcurrentHashMap<String, User> REPO;

    public UserRepository() {
        List<Authorities> toUser = new ArrayList<>();
        List<Authorities> toAdmin = new ArrayList<>();
        List<Authorities> toGuest = Collections.emptyList();
        toUser.add(Authorities.READ);
        toAdmin.add(Authorities.READ);
        toAdmin.add(Authorities.WRITE);
        toAdmin.add(Authorities.DELETE);
        User user = new User("user", "user", toUser);
        User admin = new User("admin", "admin", toAdmin);
        User guest = new User("guest", "guest", toGuest);
        REPO = new ConcurrentHashMap<>();
        REPO.put(user.getName(), user);
        REPO.put(admin.getName(), admin);
        REPO.put(guest.getName(), guest);
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!REPO.containsKey(user)) {
            throw new UnauthorizedUser("User with such name does not exist.");
        }
        if (!REPO.get(user).getPassword().equals(password)) {
            throw new InvalidCredentials("Incorrect password");
        }
        return REPO.get(user).getAuthorities();
    }
}