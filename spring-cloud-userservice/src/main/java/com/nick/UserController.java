package com.nick;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by dreamcatchernick on 25/09/2017.
 */
@RestController
public class UserController {

    private List<User> users;

    public UserController() {
        users = new ArrayList<>();
        users.add(new User(1, "testUser01", "Nick" , "Gu"));
        users.add(new User(2, "testUser02", "Mark" , "Will"));
        users.add(new User(3, "testUser03", "John" , "Joe"));
        users.add(new User(4, "testUser04", "Bill" , "Gates"));
        users.add(new User(5, "testUser05", "Steve" , "Jobs"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers() {
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    public User getUser(@PathVariable int id) {
        return users.stream().filter(u-> u.getUserId() == id).findFirst().get();
    }
}
