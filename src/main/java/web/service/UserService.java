package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {
    void create(User user);
    void update(User user);
    void delete(User user);
    void deleteById(Long id);
    User findById(Long id);
    List<User> listUsers();
    User findByUsername(String username);
}
