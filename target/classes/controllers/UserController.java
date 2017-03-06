package controllers;

import models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.UserService;

/**
 * Created by thomaz on 03/03/17.
 */

@RestController
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void save(@RequestBody Users user){
        userService.save(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody Users user) {
        userService.update(user);
    }

    @RequestMapping(value = "deleteAccount/{id}", method = RequestMethod.PUT)
    public void deleteAccount(@PathVariable("id") Integer id) {
        userService.deleteAccount(id);
    }

    @RequestMapping(value = "login/{email}/{senha}", method = RequestMethod.POST)
    public Users verifyLogin(@PathVariable("email") String email, @PathVariable("senha") String senha) {

        return userService.verifyLogin(email, senha);
    }
}
