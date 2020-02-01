package com.example.litepal.usertable;

import org.litepal.crud.LitePalSupport;

public class UserOne extends LitePalSupport {
    private String name;
    private int number;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
