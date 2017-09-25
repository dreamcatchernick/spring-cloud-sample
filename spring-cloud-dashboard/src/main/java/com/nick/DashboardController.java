package com.nick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


/**
 * Created by dreamcatchernick on 25/09/2017.
 */
@RestController
public class DashboardController {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public List<User> showAll() {
        User[] userArray = restTemplate.getForObject("http://172.16.89.94:9990/users", User[].class);
        List<User> users = Arrays.asList(userArray);
        Order[] orderArray = restTemplate.getForObject("http://172.16.89.94:9995/orders", Order[].class);
        List<Order> orders = Arrays.asList(orderArray);
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show/{userId}")
    public User show(@PathVariable int userId) {
        String userRequestUri = String.format("http://172.16.89.94:9990/users/%d", userId);

        User user = restTemplate.getForObject(userRequestUri, User.class);

        String orderRequestUri = String.format("http://172.16.89.94:9995/orders/%d", userId);

        Order order = restTemplate.getForObject(orderRequestUri, Order.class);
        return user;
    }
}
