package com.example.mysocialnetwork;

public class Friend_In_List {

    private String name;
    private String address;
    private String email;
    private int age;

    public Friend_In_List(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
