package com.nick;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dreamcatchernick on 26/09/2017.
 */
public class UserDetail {
    private int userId;
    private String userName;
    private String fullname;
    private List<Order> orders;

    public UserDetail(int userId, String userName, String fullname) {
        this.userId = userId;
        this.userName = userName;
        this.fullname = fullname;
        this.orders = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
