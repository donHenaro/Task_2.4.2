package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        em.persist(user);
    }

    @Override
    public void update(User user) {
        if(findById(user.getId()).getPassword() != user.getPassword() ){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        em.merge(user);
    }

    @Override
    public void delete(User user) {
        em.remove(user);
    }

    @Override
    public void deleteById(Long id) {
        User user = findById(id);
        if (user != null) {
            em.remove(user);
        }
    }

    @Override
    public User findById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> listUsers() {
        return em.createQuery("from User order by id", User.class).getResultList();
    }

    @Override
    public User findByUsername(String username) {
        TypedQuery<User> query = em.createQuery(
                "from User where username = :username", User.class);
        return query.setParameter("username", username).getSingleResult();
    }

}
