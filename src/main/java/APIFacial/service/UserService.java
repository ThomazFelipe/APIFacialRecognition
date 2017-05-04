package APIFacial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import APIFacial.daos.UserDao;
import APIFacial.models.Users;

/**
 * Created by thomaz on 03/03/17.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void save(Users users){
    	userDao.save(users);
    }

   
    public void deleteAccount(Integer id) {
    	userDao.deleteAccount(id);
    }

    public void update(Users user) {
    	userDao.update(user);
    }


    public Users findById(Integer id) {
       return userDao.findById(id);
    }

    public Users verifyLogin(String email, String password) {
        return userDao.verifyLogin(email, password);
    }

}
