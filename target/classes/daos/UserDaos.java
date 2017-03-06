package daos;

import models.Users;

/**
 * Created by thomaz on 03/03/17.
 */

public interface UserDaos {

    void save(Users users);

    void deleteAccount(Integer id);

    void update(Users users);

    Users findById(Integer id);

    Users verifyLogin(String email, String password);
}
