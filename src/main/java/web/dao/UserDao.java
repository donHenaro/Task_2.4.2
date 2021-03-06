package web.dao;

import org.springframework.security.core.userdetails.UserDetails;
import web.model.User;

import java.util.List;


public interface UserDao {
    void create(User user);
    void update(User user);
    void delete(User user);
    void deleteById(Long id);
    User findById(Long id);
    List<User> listUsers();
    User findByUsername(String username);
}
