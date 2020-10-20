package com.nyd.VehicleSystem.Entity.Costumer;

import java.util.Random;

public class Costumer {
    private int id ;
    private String name;
    private String address;
    private String email;
    private String cellphone;

    public Costumer(){
        Random newRandom = new Random();
        this.id = newRandom.nextInt(9999999);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }


}
