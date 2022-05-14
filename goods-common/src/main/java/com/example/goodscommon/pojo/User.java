package com.example.goodscommon.pojo;

public class User {

    private Integer Id;
    private String Name;
    private String Password;

    @Override
    public String toString() {
        return "user{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
