package service;

import daos.UserDaos;
import models.Users;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Created by thomaz on 03/03/17.
 */
@Repository
@Service
public class UserService implements UserDaos {

    UserService(){

    }
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(Users users){
        manager.persist(users);
    }

    @Transactional
    public void deleteAccount(Integer id) {
        final String ss = "DELETE Users u WHERE u.id=:idu";
        javax.persistence.Query query = manager.createQuery(ss);
        query.setParameter("idu", id);
        query.executeUpdate();
    }

    @Override
    public void update(Users user) {
        this.findById(user.getId());
        manager.merge(user);
    }

    @Override
    public Users findById(Integer id) {
        return manager.find(Users.class, id);
    }

    public Users verifyLogin(String email, String senha) {
        final String SELECT = "SELECT u FROM Users u WHERE u.email=:emailurl AND u.senha=:senhaurl";

        javax.persistence.Query query = manager.createQuery(SELECT);
        query.setParameter("emailurl", email);
        query.setParameter("senhaurl", senha);

        return (Users) query.getSingleResult();
    }
}
