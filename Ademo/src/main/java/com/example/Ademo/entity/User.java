package com.example.Ademo.entity;

import java.time.LocalDateTime;

public class User {
    private Integer id;
    private String username;
    private Integer price;
    private Integer inventory;//(商品库存)
    private LocalDateTime createTime;


    public User(){

    }


    public User(Integer id, String username, Integer price, Integer inventory, LocalDateTime createTime) {
        this.id = id;
        this.username = username;
        this.price = price;
        this.inventory = inventory;
        this.createTime = createTime;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
