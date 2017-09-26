package com.nick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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

    private UserDetailsBuilder userDetailsBuilder;
    public DashboardController() {
        this.userDetailsBuilder = new UserDetailsBuilder();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show")
    public List<UserDetail> showAll() {
        User[] userArray = restTemplate.getForObject("http://localhost:9990/users", User[].class);
        List<User> users = Arrays.asList(userArray);
        Order[] orderArray = restTemplate.getForObject("http://localhost:9995/orders", Order[].class);
        List<Order> orders = Arrays.asList(orderArray);
        List<UserDetail> userDetailList = new ArrayList<>();
        users.forEach(user -> {
            List<Order> userOrders = orders.stream().filter(order
                    -> order.getUserId() == user.getUserId()).collect(Collectors.toList());
            UserDetail userDetail = userDetailsBuilder.build(user, userOrders);
            userDetailList.add(userDetail);
        });

        return userDetailList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/show/{userId}")
    public UserDetail show(@PathVariable int userId) {
        String userRequestUri = String.format("http://localhost:9990/users/%d", userId);

        User user = restTemplate.getForObject(userRequestUri, User.class);

        String orderRequestUri = String.format("http://localhost:9995/getordersbyuserid/%d", userId);

        Order[] orderArray = restTemplate.getForObject(orderRequestUri, Order[].class);
        List<Order> orders = Arrays.asList(orderArray);
        UserDetail userDetail = userDetailsBuilder.build(user, orders);
        return userDetail;
    }
}
