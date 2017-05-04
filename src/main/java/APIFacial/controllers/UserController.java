package APIFacial.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import APIFacial.models.Users;
import APIFacial.service.UserService;


/**
 * Created by thomaz on 03/03/17.
 */

@Controller
@RestController
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

    @RequestMapping(value = "/deleteAccount/{id}", method = RequestMethod.PUT)
    public void deleteAccount(@PathVariable("id") Integer id) {
        userService.deleteAccount(id);
    }

    @RequestMapping(value = "/login/{email}/{password}", method = RequestMethod.POST)
    public Users verifyLogin(@PathVariable("email") String email, @PathVariable("password") String password) {

        return userService.verifyLogin(email, password);
    }

    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public Users getPicture(@PathVariable("id") Integer id){
        return userService.findById(id);
    }
}
