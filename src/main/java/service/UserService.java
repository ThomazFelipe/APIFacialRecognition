package service;

import daos.UserDaos;
import models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by thomaz on 03/03/17.
 */
@Repository
public class UserService implements UserDaos {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(User user){
        manager.persist(user);
    }

    @Transactional
    public void deleteAccount(Integer id) {
        final String ss = "DELETE User u WHERE u.id=:idu";
        javax.persistence.Query query = manager.createQuery(ss);
        query.setParameter("idu", id);
        query.executeUpdate();
    }

    @Override
    public void update(User user) {
        this.findById(user.getId());
        manager.merge(user);
    }

    @Override
    public User findById(Integer id) {
        return manager.find(User.class, id);
    }

    public User verifyLogin(String email, String senha) {
        final String SELECT = "SELECT u FROM User u WHERE u.email=:emailurl AND u.senha=:senhaurl";

        javax.persistence.Query query = manager.createQuery(SELECT);
        query.setParameter("emailurl", email);
        query.setParameter("senhaurl", senha);

        return (User) query.getSingleResult();
    }
}
