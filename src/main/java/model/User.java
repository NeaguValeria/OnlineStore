package model;

import java.util.Map;

public class User {

    private String userId;
    private String password;
    private Map<String, Integer>products;

    public User(String userId, String password, Map<String, Integer> products) {
        this.userId = userId;
        this.password = password;
        this.products = products;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Integer> products) {
        this.products = products;
    }
}
