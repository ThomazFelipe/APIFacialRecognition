package daos;

import models.User;

/**
 * Created by thomaz on 03/03/17.
 */
public interface UserDaos {

    void save(User user);

    void deleteAccount(Integer id);

    void update(User user);

    User findById(Integer id);

    User verifyLogin(String email, String password);
}
