package com.nick;


import java.util.List;

/**
 * Created by dreamcatchernick on 26/09/2017.
 */
public class UserDetailsBuilder {

    public UserDetail build(User user , List<Order> orders) {
        String fullName = String .format("%s %s", user.getFirstName(), user.getLastName());
        UserDetail userDetail = new UserDetail(user.getUserId() ,user.getUserName() , fullName);
        userDetail.setOrders(orders);
        return userDetail;
    }
}
