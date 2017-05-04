package APIFacial.daos;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import APIFacial.models.Users;

/**
 * Created by thomaz on 03/03/17.
 */
@Repository
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager manager;

    public void save(Users users){
        manager.persist(users);
    }
   
    public void deleteAccount(Integer id) {
        final String ss = "DELETE Users u WHERE u.id=:idu";
        javax.persistence.Query query = manager.createQuery(ss);
        query.setParameter("idu", id);
        query.executeUpdate();
    }

    public void update(Users user) {
        this.findById(user.getId());
        manager.merge(user);
    }

    public Users findById(Integer id) {
        return manager.find(Users.class, id);
    }

    public Users verifyLogin(String email, String password) {
        javax.persistence.Query query = manager.createQuery("SELECT u FROM Users u " +
                "WHERE u.email=:emailurl AND u.password=:senhaurl");
        query.setParameter("emailurl", email);
        query.setParameter("senhaurl", password);

        return (Users) query.getSingleResult();
    }
}
