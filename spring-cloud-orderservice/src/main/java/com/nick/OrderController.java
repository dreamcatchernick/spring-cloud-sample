package com.nick;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by dreamcatchernick on 25/09/2017.
 */
@RestController
public class OrderController {

    private List<Order> orders;
    public OrderController() {
        orders = new ArrayList<>();
        orders.add(new Order(1, 1 ,21.99, "This is Nick's order" , new Date()));
        orders.add(new Order(2, 2 ,0.99, "This is Mark's order" , new Date()));
        orders.add(new Order(3, 3 ,5.00, "This is John's order" , new Date()));
        orders.add(new Order(4, 4 ,100.00, "This is Bill's order" , new Date()));
        orders.add(new Order(5, 5 ,88.11, "This is Steve's order" , new Date()));
        orders.add(new Order(6, 1 ,77.96, "This is Nick's order" , new Date()));
        orders.add(new Order(7, 1 ,9.20, "This is Nick's order" , new Date()));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public List<Order> getAllOrders() {
        return orders;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getordersbyuserid/{userId}")
    public List<Order> getOrder(@PathVariable int userId) {
        return orders.stream().filter(o -> o.getUserId() == userId).collect(Collectors.toList());
    }
}
